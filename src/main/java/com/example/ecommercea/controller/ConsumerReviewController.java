//package com.example.ecommercea.controller;
//import com.example.ecommercea.DuplicateNameException;
//import com.example.ecommercea.domain.ConsumerReview;
//import com.example.ecommercea.register.ConsumerReviewRegister;
//
//import com.example.ecommercea.service.ConsumerReviewService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/consumerReview")
//@RequiredArgsConstructor
//public class ConsumerReviewController {//소비자 리뷰
//    private final ConsumerReviewService consumerReviewService;
//
//    @PostMapping("/create")//상품 생성
//    public ResponseEntity<?> createConsumerReview(@RequestBody ConsumerReviewRegister consumerReviewRegister){
//        try {ConsumerReview consumerReview= consumerReviewService.createConsumerReview(consumerReviewRegister);
//            return ResponseEntity.status(HttpStatus.CREATED).body(consumerReview);
//        }catch (DuplicateNameException e){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[3]
//
//    @GetMapping("/get/{ConsumerReviewNumber}")//상품 정보 가져옴
//    public ResponseEntity<ConsumerReview>getConsumerReview(@PathVariable Long ConsumerReviewNumber){
//        ConsumerReview consumerReview= consumerReviewService.getConsumerReview(ConsumerReviewNumber);
//        if(consumerReview!=null){return ResponseEntity.ok(consumerReview);
//        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}
//
//    @PutMapping("/change/{ConsumerReviewNumber}")//상품 정보 수정
//    public ResponseEntity<?>changeConsumerReview(@PathVariable Long ConsumerReviewNumber,
//    @RequestBody ConsumerReviewRegister consumerReviewRegister){
//
//        try{ConsumerReview changeConsumerReview= consumerReviewService.changeConsumerReview
//(ConsumerReviewNumber,consumerReviewRegister);return ResponseEntity.ok(changeConsumerReview);
//        }catch (DuplicateNameException e){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
//                    ("잘못된 요청"+e.getMessage());}}//[4][31][32][33][34]
//
//    @DeleteMapping("/delete/{ConsumerReviewNumber}")//상품 삭제
//    public void deleteConsumerReview(@PathVariable Long ConsumerReviewNumber){
//        consumerReviewService.deleteConsumerReview(ConsumerReviewNumber);}}