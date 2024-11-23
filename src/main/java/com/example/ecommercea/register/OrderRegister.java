package com.example.ecommercea.register;
import com.example.ecommercea.domain.Order;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrderRegister {//주문 등록
    private String orderName;//주문 이름
    private Long customerID;//고객 ID
    private Long sellerID;//판매자 ID

    private Long cartID;//장바구니 ID
    private String productName;//상품 이름
    private int ordersCount;//주문한 상품 개수

    private String category;//분류
    private Long cost;//상품 가격
    private Long productID;//상품 ID

    public static Order changeForm(OrderRegister orderRegister){
        return Order.builder().orderName(orderRegister.getOrderName())
                .customerID(orderRegister.getCustomerID())
                .sellerID(orderRegister.getSellerID())

                .cartID(orderRegister.getCartID())
                .productName(orderRegister.getProductName())
                .ordersCount(orderRegister.getOrdersCount())

                .category(orderRegister.getCategory())
                .cost(orderRegister.getCost())
                .productID(orderRegister.getProductID()).build();}}