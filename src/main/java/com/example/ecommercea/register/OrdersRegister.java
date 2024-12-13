package com.example.ecommercea.register;
import com.example.ecommercea.domain.Consumer;
import com.example.ecommercea.domain.Orders;
import com.example.ecommercea.domain.OrdersItem;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrdersRegister {//주문 등록
    private Long ordersNumber;//주문 번호 [39][40]
    private String ordersName;//주문 이름
    private Long consumerID;//고객 ID
    private Consumer consumer;//고객
    private Long cartID;//장바구니 ID

    private List<OrdersItem> ordersItems;//주문 상품 리스트

    public static Orders ordersForm(OrdersRegister ordersRegister){
        Orders orders= Orders.builder().ordersName(ordersRegister.getOrdersName())
                .consumer(ordersRegister.getConsumer())
                .consumerID(ordersRegister.getConsumerID())
                .cartID(ordersRegister.getCartID()).build();

        List<OrdersItem>ordersItems=new ArrayList<>();
        for(OrdersItem item: ordersRegister.getOrdersItems()){
            item.setOrders(orders);}//주문에다 아이템 연결
 orders.setOrdersItems(ordersRegister.getOrdersItems()); return orders;}}//[6]~[18]