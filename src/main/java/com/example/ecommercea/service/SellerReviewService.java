package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Seller;
import com.example.ecommercea.domain.SellerReview;
import com.example.ecommercea.register.SellerReviewRegister;
import com.example.ecommercea.repository.SellerReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerReviewService { //판매자 리뷰
    private final SellerReviewRepository sellerReviewRepository;

    public SellerReview createSellerReview(SellerReviewRegister sellerReviewRegister){//판매자 리뷰 삭제
        if(sellerReviewRepository.existsByTitle2(sellerReviewRegister.getTitle2())){
            throw new DuplicateNameException("소비자 이름 이미 있음");}
        return sellerReviewRepository.save(SellerReviewRegister.sellerReviewForm(sellerReviewRegister));}

    public SellerReview getSellerReview(Long sellerReviewNumber){//판매자 리뷰 정보 조회
        return sellerReviewRepository.findById(sellerReviewNumber).orElse(null);}

    public List<SellerReview> getAllSellerReviews(){//모든 판매자 리뷰 정보 가져옴
        return sellerReviewRepository.findAll();}//[40]

    public SellerReview changeSellerReview(Long sellerReviewNumber,
    SellerReviewRegister sellerReviewRegister){//판매자 리뷰 정보 조회
        SellerReview saved= sellerReviewRepository.findById(sellerReviewNumber)
                .orElseThrow(()->new RuntimeException("판매자 리뷰 없음"));

    if(sellerReviewRepository.existsByTitle2(sellerReviewRegister.getTitle2())){
        throw new DuplicateNameException("리뷰 제목 이미 있음");}
        saved.sellerReviewChange(sellerReviewRegister);return sellerReviewRepository.save(saved);}

    public void deleteSellerReview(Long sellerReviewNumber){//판매자 리뷰 삭제
        sellerReviewRepository.deleteBySellerReviewNumber(sellerReviewNumber);}}