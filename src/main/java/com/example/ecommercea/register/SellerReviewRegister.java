package com.example.ecommercea.register;
import com.example.ecommercea.domain.Category2;

import com.example.ecommercea.domain.SellerReview;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SellerReviewRegister {//판매자 리뷰 생성
    private Category2 category2;//카테고리
    private Long sellerID;//판매자 ID
    private Long consumerID;//소비자 ID

    private String title2;//제목 [29]
    private int score2;//점수(평점)
    private String review2;//리뷰 내용
    private String reReview2;//리뷰에 대한 댓글

    public static SellerReview sellerReviewForm(SellerReviewRegister sellerReviewRegister){
        return SellerReview.builder().category2(sellerReviewRegister.getCategory2())
                .sellerID(sellerReviewRegister.getSellerID())
                .consumerID(sellerReviewRegister.getConsumerID())

                .title2(sellerReviewRegister.getTitle2())
                .score2(sellerReviewRegister.getScore2())
                .review2(sellerReviewRegister.getReview2())
                .reReview2(sellerReviewRegister.getReReview2()).build();}}//[4][30][35]