package com.example.ecommercea.domain;
import com.example.ecommercea.register.OrdersRegister;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder

public class Orders extends BaseEntity{@Id//주문
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersNumber;//주문 번호

    @NotNull(message = "주문 명단 작성 필수")
    @Size(min=3)
    private String ordersName;//주문 이름

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer")
    private Consumer consumer;//고객 정보

    private Long consumerID;//고객 ID
    private Long cartID;//장바구니 ID

    @OneToMany(mappedBy = "orders",cascade =
            CascadeType.ALL, orphanRemoval = true)//주문한 상품 리스트
    private List<OrdersItem>ordersItems=new ArrayList<>();

    public void addOrderItem(OrdersItem ordersItem) {//주문 내역 추가 메서드
 ordersItems.add(ordersItem);ordersItem.setOrders(this);}

    public void removeOrderItem(OrdersItem ordersItem){//주문 내역 삭제 메서드
ordersItems.remove(ordersItem);ordersItem.setOrders(null);}

    public void ordersChange(OrdersRegister ordersRegister){//주문 내역 수정 메서드
        this.ordersName = ordersRegister.getOrdersName();
        this.consumer= ordersRegister.getConsumer();
        this.cartID= ordersRegister.getCartID();

        this.ordersItems.clear();//기존 주문 항목 삭제

    for(OrdersItem itemRegister:ordersRegister.getOrdersItems()){
        OrdersItem ordersItem=new OrdersItem();
        ordersItem.setConsumerID(itemRegister.getConsumerID());
        ordersItem.setProductID(itemRegister.getProductID());
        ordersItem.setProductName(itemRegister.getProductName());
        ordersItem.setSellerID(itemRegister.getSellerID());
        ordersItem.setOrdersCount(itemRegister.getOrdersCount());
        ordersItem.setCost(itemRegister.getCost());
        ordersItem.setCategory(itemRegister.getCategory());}}}//[6]~[18]