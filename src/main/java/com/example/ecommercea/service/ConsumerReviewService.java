package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.ConsumerReview;
import com.example.ecommercea.register.ConsumerReviewRegister;

import com.example.ecommercea.repository.ConsumerReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ConsumerReviewService {//소비자 리뷰
    private final ConsumerReviewRepository consumerReviewRepository;

    public ConsumerReview createConsumerReview(ConsumerReviewRegister consumerReviewRegister){//소비자 리뷰 생성
        if(consumerReviewRepository.existsByTitle(consumerReviewRegister.getTitle())){
            throw new DuplicateNameException("소비자 리뷰 제목 이미 있음");}
        return consumerReviewRepository.save(ConsumerReviewRegister.consumerReviewForm(consumerReviewRegister));}

    public ConsumerReview getConsumerReview(Long consumerReviewNumber){//소비자 리뷰 정보 가져옴
        return consumerReviewRepository.findById(consumerReviewNumber).orElse(null);}

    public List<ConsumerReview> getAllConsumerReviews(){//모든 소비자 리뷰 정보 가져옴
        return consumerReviewRepository.findAll();}//[40]

    public ConsumerReview changeConsumerReview(Long ConsumerReviewNumber,
             ConsumerReviewRegister consumerReviewRegister){//소비자 리뷰 정보 수정
        ConsumerReview saved= consumerReviewRepository.findById(ConsumerReviewNumber)
                .orElseThrow(()->new RuntimeException("소비자 리뷰 없음"));

        if(consumerReviewRepository.existsByTitle(consumerReviewRegister.getTitle())){
            throw new DuplicateNameException("소비자 리뷰 제목 이미 있음");}
        saved.consumerReviewChange(consumerReviewRegister);return consumerReviewRepository.save(saved);}

    public void deleteConsumerReview(Long consumerReviewNumber){//소비자 리뷰 삭제
    consumerReviewRepository.deleteByConsumerReviewNumber(consumerReviewNumber);}}