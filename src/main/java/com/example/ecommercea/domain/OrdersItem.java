package com.example.ecommercea.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder

public class OrdersItem extends BaseEntity{ @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersItemID;//상품 주문 ID

    private Long consumerID;//소비자 ID
    private Long productID;//상품 ID
    private String productName;//상품 이름
    private Long sellerID;//판매자 ID

    private int ordersCount;//주문한 상품 개수
    private Long cost;//상품 가격
    private String category;//분류

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_number")
    @JsonIgnore//[41]~[46] 특히 [46]
    private Orders orders;}//[6]~[18]