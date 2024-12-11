package com.example.ecommercea.register;
import com.example.ecommercea.domain.Category;
import com.example.ecommercea.domain.ConsumerReview;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ConsumerReviewRegister {//소비자 리뷰 생성
    private Category category;//카테고리
    private Long consumerID;//소비자 ID

    private Long productID;//물품 ID
    private Long ordersNumber;//주문 번호
    private Long sellerID;//판매자 ID

    private String title;//제목[29]
    private int score;//점수(평점)
    private String review;//리뷰 내용
    private String reReview;//리뷰에 대한 댓글

    public static ConsumerReview consumerReviewForm(ConsumerReviewRegister consumerReviewRegister){
        return ConsumerReview.builder().category(consumerReviewRegister.getCategory())
                .consumerID(consumerReviewRegister.getConsumerID())

                .productID(consumerReviewRegister.getProductID())
                .ordersNumber(consumerReviewRegister.getOrdersNumber())
                .sellerID(consumerReviewRegister.getSellerID())

                .title(consumerReviewRegister.getTitle())
                .score(consumerReviewRegister.getScore())
                .review(consumerReviewRegister.getReview())
                .reReview(consumerReviewRegister.getReReview()).build();}}//[4][30][35][36][37]