package com.example.ecommercea.register;
import com.example.ecommercea.domain.Seller;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerRegister {//판매자용 회원등록

    private String sellerName;
    private String sellerPW;
    private Long sellerAccountNumber;
    private Long sellerPhoneNumber;
    private String sellerReview;

    public static Seller sellerForm(SellerRegister sellerRegister){
        return Seller.builder().sellerName(sellerRegister.getSellerName())
                .sellerPW(sellerRegister.getSellerPW())
                .sellerAccountNumber(sellerRegister.getSellerAccountNumber())
                .sellerPhoneNumber(sellerRegister.getSellerPhoneNumber())
                .sellerReview(sellerRegister.getSellerReview()).build();}}