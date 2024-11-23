package com.example.ecommercea.domain;
import com.example.ecommercea.register.ProductRegister;
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

public class Product extends BaseEntity{@Id//상품
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long productID;//상품 ID

    @NotNull(message = "이름 작성 필수")
    @Size(min=3)
    private String productName;//상품 이름
    private Long sellerID;//판매자 ID
    private Long cost;//상품 가격

    private String category;//상품 분류
    private String information;//상품 정보
    private Long productNumber;//상품 번호
    private int stock;//상품(재고) 계수

    public void productChange(ProductRegister productRegister){//[4]
        this.productName=productRegister.getProductName();
        this.sellerID=productRegister.getSellerID();
        this.cost=productRegister.getCost();
        this.category=productRegister.getCategory();
        this.information=productRegister.getInformation();
        this.productNumber=productRegister.getProductNumber();
        this.stock=productRegister.getStock();}}