package com.example.ecommercea.repository;
import com.example.ecommercea.domain.SellerReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SellerReviewRepository extends JpaRepository<SellerReview,Long> {
    boolean existsByTitle2(String title2);//제목으로 중복된 판매자 리뷰 제목이 있는지 여부 확인
    SellerReview findBySellerReviewNumber(Long sellerReviewNumber);//판매자 리뷰 번호로 해당 판매자 리뷰 찾기
    void deleteBySellerReviewNumber(Long sellerReviewNumber);}//판매자 리뷰 번호로 해당 판매자 리뷰 찾아 삭제 [4]