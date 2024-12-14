package com.example.ecommercea.repository;
import com.example.ecommercea.domain.ConsumerReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ConsumerReviewRepository extends JpaRepository<ConsumerReview,Long> {//소비자 리뷰
    boolean existsByTitle(String title);//제목으로 중복된 소비자 리뷰 제목이 있는지 여부 확인
    ConsumerReview findByConsumerReviewNumber(Long consumerReviewNumber);//소비자 리뷰 번호로 해당 소비자 리뷰 찾기
    void deleteByConsumerReviewNumber(Long consumerReviewNumber);}//소비자 리뷰로 해당 소비자 리뷰 찾아 삭제 [4]