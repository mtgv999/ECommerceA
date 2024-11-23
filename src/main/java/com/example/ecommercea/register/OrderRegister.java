package com.example.ecommercea.register;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRegister {//주문 등록
    private Long ordersNumber;//주문 번호
    private String orderList;//주문 명단
    private Long customerID;//고객 ID

    private Long sellerID;//판매자 ID
    private Long cartID;//장바구니 ID
    private String productName;//상품 이름

    private int ordersCount;//주문한 상품 개수
    private String category;//분류
    private Long cost;//상품 가격
    private Long productID;//상품 ID
}