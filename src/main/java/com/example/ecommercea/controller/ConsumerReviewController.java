package com.example.ecommercea.controller;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.ConsumerReview;
import com.example.ecommercea.register.ConsumerReviewRegister;

import com.example.ecommercea.service.ConsumerReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumerReview")
@RequiredArgsConstructor
public class ConsumerReviewController {//소비자 리뷰
    private final ConsumerReviewService consumerReviewService;

    @PostMapping("/create")//소비자 리뷰 생성(같은 이름 있으면 만들 수 없음.)
public ResponseEntity<?> createConsumerReview(@RequestBody ConsumerReviewRegister consumerReviewRegister){
try {ConsumerReview consumerReview= consumerReviewService.createConsumerReview(consumerReviewRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(consumerReview);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[3]

    @GetMapping("/get/{consumerReviewNumber}")//소비자 리뷰 정보 가져옴
    public ResponseEntity<ConsumerReview>getConsumerReview(@PathVariable Long consumerReviewNumber){
        ConsumerReview consumerReview= consumerReviewService.getConsumerReview(consumerReviewNumber);
        if(consumerReview!=null){return ResponseEntity.ok(consumerReview);
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @GetMapping("/getAll") public List<ConsumerReview> getAllConsumerReviews(){//모든 소비자 리뷰 정보 가져옴
        List<ConsumerReview> consumerReview = consumerReviewService.getAllConsumerReviews();
        consumerReview.forEach(System.out::println);return consumerReview;}//[40]

    @PutMapping("/change/{consumerReviewNumber}")//소비자 리뷰 수정(같은 이름 있으면 만들 수 없음.)
    public ResponseEntity<?>changeConsumerReview(@PathVariable Long consumerReviewNumber,
        @RequestBody ConsumerReviewRegister consumerReviewRegister){

        try{ConsumerReview changeConsumerReview= consumerReviewService.changeConsumerReview
(consumerReviewNumber,consumerReviewRegister);return ResponseEntity.ok(changeConsumerReview);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        }catch (Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
                ("잘못된 요청 -"+e.getMessage());}}//[4][31][32][33][34]

    @DeleteMapping("/delete/{consumerReviewNumber}")//소비자 리뷰 삭제
    public void deleteConsumerReview(@PathVariable Long consumerReviewNumber){
        consumerReviewService.deleteConsumerReview(consumerReviewNumber);}}