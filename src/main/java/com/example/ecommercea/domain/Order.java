package com.example.ecommercea.domain;
import com.example.ecommercea.register.OrderRegister;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder

public class Order extends BaseEntity{@Id//주문
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersNumber;//주문 번호

    @NotNull(message = "주문 명단 작성 필수")
    @Size(min=1)
    private String orderList;//주문 명단
    private Long customerID;//고객 ID

    private Long sellerID;//판매자 ID
    private Long cartID;//장바구니 ID
    private String productName;//상품 이름

    private int ordersCount;//주문한 상품 개수
    private String category;//분류
    private Long cost;//상품 가격
    private Long productID;//상품 ID

    private void ordersChange(OrderRegister orderRegister){
        this.orderList=orderRegister.}}