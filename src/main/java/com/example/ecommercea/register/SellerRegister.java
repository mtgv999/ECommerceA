package com.example.ecommercea.register;
import com.example.ecommercea.domain.Seller;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SellerRegister {//판매자용 회원등록
    private String sellerName;//판매자 이름
    private String sellerPW;//판매자 비밀번호
    private String sellerAccountNumber;//판매자 계좌번호
    private String sellerPhoneNumber;//판매자 전화번호
    private String sellerReview;//판매자 리뷰
    private String companyName;//회사 이름

    public static Seller sellerForm(SellerRegister sellerRegister) {
        return Seller.builder().sellerName(sellerRegister.getSellerName())
                .sellerPW(sellerRegister.getSellerPW())
                .sellerAccountNumber(sellerRegister.getSellerAccountNumber())
                .sellerPhoneNumber(sellerRegister.getSellerPhoneNumber())
                .sellerReview(sellerRegister.getSellerReview())
                .companyName(sellerRegister.companyName).build();}}