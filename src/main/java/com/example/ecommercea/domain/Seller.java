package com.example.ecommercea.domain;
import com.example.ecommercea.register.SellerRegister;
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

public class Seller extends BaseEntity{@Id//판매자
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long sellerID;//판매자 아이디

    @NotNull(message = "이름 작성 필수")
    @Size(min=5)
    private String sellerName;//판매자 이름

    @NotNull(message = "PW 작성 필수")
    @Size(min=8)
    private String sellerPW;//판매자 비밀 번호

    private Long sellerAccountNumber;//판매자 계좌 번호
    private Long sellerPhoneNumber;//판매자 휴대폰 번호
    private String sellerReview;//판매자 리뷰

    public void sellerChange(SellerRegister sellerRegister){//[4]
        this.sellerName=sellerRegister.getSellerName();
        this.sellerPW=sellerRegister.getSellerPW();
        this.sellerAccountNumber=sellerRegister.getSellerAccountNumber();
        this.sellerPhoneNumber=sellerRegister.getSellerPhoneNumber();
        this.sellerReview=sellerRegister.getSellerReview();}}//[3]