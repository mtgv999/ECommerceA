package com.example.ecommercea.domain;

import com.example.ecommercea.register.CartRegister;
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

public class Cart extends BaseEntity{@Id//장바구니
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartID;//장바구니 ID

    @NotNull(message = "장바구니 이름 작성 필수")
    @Size(min=3)
    private String cartName;//장바구니 이름

    @NotNull(message = "상품 이름 작성 필수")
    @Size(min=3)
    private String productName;//상품 이름

    private Long sellerID;//판매자
    private Long customerID;//고객
    private int cartStock;//장바구니 내 상품의 총 개수

    private Long totalCost;//가격 총합
    private Long cartNumber;//장바구니 번호
    private Long productID;//상품 아이디

    public void cartChange(CartRegister cartRegister){//[4]
        this.cartName=cartRegister.getCartName();
        this.productName=cartRegister.getProductName();

        this.sellerID=cartRegister.getSellerID();
        this.customerID=cartRegister.getCustomerID();
        this.cartStock=cartRegister.getCartStock();

        this.totalCost=cartRegister.getTotalCost();
        this.cartNumber=cartRegister.getCartNumber();
        this.productID=cartRegister.getProductID();}}
