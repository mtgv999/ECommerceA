package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Orders;
import com.example.ecommercea.register.OrdersRegister;
import com.example.ecommercea.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrdersService {//주문
    private final OrdersRepository ordersRepository;

    public Orders createOrders(OrdersRegister ordersRegister){
        if(ordersRepository.existsByOrdersName(ordersRegister.getOrdersName())){
            throw new DuplicateNameException("주문 이름 이미 있음");}
        return ordersRepository.save(OrdersRegister.ordersForm(ordersRegister));}//[3]

    public Orders getOrders(Long ordersID){
        return ordersRepository.findOrdersWithItems(ordersID).orElse(null);}//[20]~[24]

    public Map<String,Object> getOrdersDetails(Long ordersNumber){
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

    public Orders changeOrders(Long ordersID, OrdersRegister ordersRegister){
        Orders saved= ordersRepository.findById(ordersID)
                .orElseThrow(()->new RuntimeException("주문 없음"));
        saved.ordersChange(ordersRegister);return saved;}//[4]

    public void deleteOrders(Long ordersID){
        ordersRepository.deleteByOrdersNumber(ordersID);}}//[3][5]