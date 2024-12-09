package com.example.ecommercea.register;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersItemRegister {
    private Long consumerID;//고객 ID
    private Long productID;//상품 ID
    private String productName;//상품 이름
    private Long sellerID;//판매자 ID

    private int ordersCount;//주문한 상품 개수
    private Long cost;//상품 가격
    private String category;}//분류[6]~[18]