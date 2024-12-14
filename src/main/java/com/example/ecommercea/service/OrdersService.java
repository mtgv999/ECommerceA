package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Orders;
import com.example.ecommercea.domain.OrdersItem;
import com.example.ecommercea.register.OrdersRegister;
//import com.example.ecommercea.repository.OrdersItemRepository;
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

    public Orders getOrders(Long ordersID){//주문과 주문 내 모든 상품들 정보 가져옴
        return ordersRepository.findOrdersWithItems(ordersID).orElse(null);}//[20]~[24]

    public List<Orders> getAllOrdersWithItems() {//모든 주문과 주문 내 모든 상품들 정보 가져옴
         return ordersRepository.findAllWithItems();}//[41][42][43] 특히 [43]

    public List<OrdersRegister> getOrdersWithItemsByConsumer(Long consumerID){
        //고객 계정으로 누가 어떤 주문을 했는지 어떤 물품을 주문했는지 주문 정보를 가져옴.
        List<Orders> ordersList=ordersRepository.findByConsumerID(consumerID);
        List<OrdersRegister> ordersRegistersList=new ArrayList<>();
        for(Orders orders : ordersList){

            //주문 번호를 기반으로 주문 항목 가져옴.
            List<OrdersItem> ordersItems=ordersItemRepository
                    .findByOrders_OrdersNumber(orders.getOrdersNumber());

            //Register로 변환해 소비자 ID, 주문, 주문 항목 정보 포함.
            OrdersRegister ordersRegister=new OrdersRegister();
            ordersRegister.setConsumerID(orders.getConsumerID());
            ordersRegister.setOrdersName(orders.getOrdersName());

            ordersRegister.setOrdersNumber(orders.getOrdersNumber());
            ordersRegister.setOrdersItems(ordersItems);
            ordersRegistersList.add(ordersRegister);}return ordersRegistersList;}//[39] */

    public Orders changeOrders(Long ordersID, OrdersRegister ordersRegister){//주문 정보 수정
        Orders saved= ordersRepository.findById(ordersID)
                .orElseThrow(()->new RuntimeException("주문 없음"));

       if(ordersRepository.existsByOrdersName(ordersRegister.getOrdersName())){
           throw new DuplicateNameException("주문 이미 있음");}
        saved.ordersChange(ordersRegister);return saved;}//[4]

    public void deleteOrders(Long ordersID){//주문 삭제
        ordersRepository.deleteByOrdersNumber(ordersID);}}//[3][5]