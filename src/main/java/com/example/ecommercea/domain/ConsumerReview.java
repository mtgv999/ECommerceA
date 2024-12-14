package com.example.ecommercea.domain;
import com.example.ecommercea.register.ConsumerReviewRegister;
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

public class ConsumerReview extends BaseEntity {@Id//소비자 리뷰
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long consumerReviewNumber;//소비자 리뷰 번호
    private Category category;//카테고리: 필수
    private Long consumerID;//소비자 ID

    private Long productID;//상품 ID
    private Long ordersNumber;//주문 번호
    private Long sellerID;//판매자 ID

    @NotNull(message = "제목 작성 필수")
    @Size(min=3)
    private String title;//소비자 리뷰 제목 [29]

    @Min(value = 0, message = "최소 0")
    @Max(value = 10, message = "최대 10")
    private int score;//점수(평점)

    @NotNull(message = "리뷰 내용 필수")
    @Size(min=3)
    private String review;//리뷰 내용
    private String reReview;//리뷰에 대한 댓글

    public void consumerReviewChange(ConsumerReviewRegister consumerReviewRegister){
        this.category=consumerReviewRegister.getCategory();
        this.consumerID=consumerReviewRegister.getConsumerID();

        this.productID=consumerReviewRegister.getProductID();
        this.ordersNumber=consumerReviewRegister.getOrdersNumber();
        this.sellerID=consumerReviewRegister.getSellerID();

        this.title=consumerReviewRegister.getTitle();
        this.score=consumerReviewRegister.getScore();
        this.review=consumerReviewRegister.getReview();
        this.reReview=consumerReviewRegister.getReReview();}}//[4][30][35][36][37]