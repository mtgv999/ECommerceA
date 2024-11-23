package com.example.ecommercea.register;
import com.example.ecommercea.domain.Orders;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrdersRegister {//주문 등록
    private String ordersName;//주문 이름
    private Long customerID;//고객 ID
    private Long sellerID;//판매자 ID

    private Long cartID;//장바구니 ID
    private String productName;//상품 이름
    private int ordersCount;//주문한 상품 개수

    private String category;//분류
    private Long cost;//상품 가격
    private Long productID;//상품 ID

    public static Orders changeForm(OrdersRegister ordersRegister){
        return Orders.builder().ordersName(ordersRegister.getOrdersName())
                .customerID(ordersRegister.getCustomerID())
                .sellerID(ordersRegister.getSellerID())

                .cartID(ordersRegister.getCartID())
                .productName(ordersRegister.getProductName())
                .ordersCount(ordersRegister.getOrdersCount())

                .category(ordersRegister.getCategory())
                .cost(ordersRegister.getCost())
                .productID(ordersRegister.getProductID()).build();}}