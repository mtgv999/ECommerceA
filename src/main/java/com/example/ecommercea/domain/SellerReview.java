package com.example.ecommercea.domain;
import com.example.ecommercea.register.SellerReviewRegister;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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

public class SellerReview extends BaseEntity{@Id//판매자
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerReviewNumber;//소비자 리뷰 번호
    private Category2 category2;//카테고리2: 필수
    private Long sellerID;//판매자 ID
    private Long consumerID;//소비자 ID

    @NotNull(message = "제목 작성 필수")
    @Size(min=3)
    private String title2;//판매자 리뷰 제목2 [29]

    @Min(value = 0, message = "최소 0")
    @Max(value = 10, message = "최대 10")
    private int score2;//점수(평점)2

    @NotNull(message = "내용 작성 필수")
    @Size(min=3)
    private String review2;//리뷰 내용2
    private String reReview2;//리뷰에 대한 댓글2

        public void sellerReviewChange(SellerReviewRegister sellerReviewRegister){
            this.category2=sellerReviewRegister.getCategory2();
            this.sellerID=sellerReviewRegister.getSellerID();
            this.consumerID=sellerReviewRegister.getSellerID();

            this.title2=sellerReviewRegister.getTitle2();
            this.score2=sellerReviewRegister.getScore2();
            this.review2=sellerReviewRegister.getReview2();
            this.reReview2=sellerReviewRegister.getReReview2();}}// [4][30][35][36][37]