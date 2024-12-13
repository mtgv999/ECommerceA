package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Orders;
import com.example.ecommercea.domain.OrdersItem;
import com.example.ecommercea.register.OrdersRegister;
import com.example.ecommercea.repository.OrdersItemRepository;
import com.example.ecommercea.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrdersService {//주문
    private final OrdersRepository ordersRepository;
    private final OrdersItemRepository ordersItemRepository;

    public Orders createOrders(OrdersRegister ordersRegister){//주문 생성
        if(ordersRepository.existsByOrdersName(ordersRegister.getOrdersName())){
            throw new DuplicateNameException("주문 이름 이미 있음");}
        return ordersRepository.save(OrdersRegister.ordersForm(ordersRegister));}//[3]

    public Orders getOrders(Long ordersID){//주문 정보 가져옴
        return ordersRepository.findOrdersWithItems(ordersID).orElse(null);}//[20]~[24]

    public Map<String,Object> getOrdersDetails(Long ordersNumber){
        //주문번호을 통해 주문한 소비자와 주문 내용 찾기
        Orders orders=ordersRepository.findByIdWithConsumer(ordersNumber).
                orElseThrow(()->new IllegalArgumentException("주문 없음"));

        Map<String, Object> response = new HashMap<>();
        response.put("ordersName", orders.getOrdersName());

        Map<String, Object> consumer = new HashMap<>();
        consumer.put("ConsumerName", orders.getConsumer().getConsumerName());
        response.put("consumer", consumer);

        List<Map<String, Object>> items = orders.getOrdersItems().stream().map(item -> {
            Map<String, Object> itemMap = new HashMap<>();
            itemMap.put("ordersItemID", item.getOrdersItemID());
            itemMap.put("productID", item.getProductID());
            itemMap.put("productName", item.getProductName());
            itemMap.put("sellerID", item.getSellerID());
            itemMap.put("ordersCount", item.getOrdersCount());
            itemMap.put("cost", item.getCost());
            itemMap.put("category", item.getCategory());
            return itemMap;
        }).collect(Collectors.toList());
        response.put("ordersItems", items);return response;}//[19][25][26][27]

    public List<OrdersRegister> getOrdersWithItemsByCustomer(Long customerID) {
        //소비자 계정으로 누가 어떤 주문을 했는지 어떤 물품을 주문했는지 주문 정보를 가져옴.
        List<Orders> ordersList = ordersRepository.findByConsumerID(customerID);

        List<OrdersRegister> ordersDTOList = new ArrayList<>();

        for (Orders order : ordersList) {
            // 주문 번호를 기반으로 주문 항목 가져옴.
            List<OrdersItem> orderItems = ordersItemRepository.findByOrders_OrdersNumber(order.getOrdersNumber());

            // DTO로 변환하여 고객 ID, 주문, 주문 항목 정보를 포함
            OrdersRegister ordersRegister = new OrdersRegister();
            ordersRegister.setConsumerID(order.getConsumerID());
            ordersRegister.setOrdersName(order.getOrdersName());
            ordersRegister.setOrdersNumber(order.getOrdersNumber());
            ordersRegister.setOrdersItems(orderItems);
            ordersDTOList.add(ordersRegister);}return ordersDTOList;}//[39]

    public List<Orders> getAllOrders() {//모든 주문 정보 가져옴
        return ordersRepository.findAll();}//[40]

    public Orders changeOrders(Long ordersID, OrdersRegister ordersRegister){//주문 정보 수정
        Orders saved= ordersRepository.findById(ordersID)
                .orElseThrow(()->new RuntimeException("주문 없음"));

       if(ordersRepository.existsByOrdersName(ordersRegister.getOrdersName())){
           throw new DuplicateNameException("주문 이미 있음");}
        saved.ordersChange(ordersRegister);return saved;}//[4]

    public void deleteOrders(Long ordersID){//주문 삭제
        ordersRepository.deleteByOrdersNumber(ordersID);}}//[3][5]