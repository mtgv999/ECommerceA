package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.SellerReview;
import com.example.ecommercea.register.SellerReviewRegister;
import com.example.ecommercea.repository.SellerReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerReviewService { //판매자 리뷰
    private final SellerReviewRepository sellerReviewRepository;

    public SellerReview createSellerReview(SellerReviewRegister sellerReviewRegister){
        if(sellerReviewRepository.existsByTitle2(sellerReviewRegister.getTitle2())){
            throw new DuplicateNameException("소비자 이름 이미 있음");}
        return sellerReviewRepository.save(SellerReviewRegister.sellerReviewForm(sellerReviewRegister));}

    public SellerReview getSellerReview(Long sellerReviewNumber){
        return sellerReviewRepository.findById(sellerReviewNumber).orElse(null);}

    public SellerReview changeSellerReview
            (Long sellerReviewNumber, SellerReviewRegister sellerReviewRegister){
        SellerReview saved= sellerReviewRepository.findById(sellerReviewNumber)
                .orElseThrow(()->new RuntimeException("판매자 리뷰 없음"));

    if(sellerReviewRepository.existsByTitle2(sellerReviewRegister.getTitle2())){
        throw new DuplicateNameException("리뷰 제목 이미 있음");}
        saved.sellerReviewChange(sellerReviewRegister);return sellerReviewRepository.save(saved);}

    public void deleteSellerReview(Long sellerReviewNumber){
        sellerReviewRepository.deleteBySellerReviewNumber(sellerReviewNumber);}}