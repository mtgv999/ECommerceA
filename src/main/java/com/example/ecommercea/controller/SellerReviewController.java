package com.example.ecommercea.controller;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.SellerReview;
import com.example.ecommercea.register.SellerReviewRegister;
import com.example.ecommercea.service.SellerReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellerReview")
@RequiredArgsConstructor
public class SellerReviewController {//판매자 리뷰
    private final SellerReviewService sellerReviewService;

    @PostMapping("/create")//판매자 리뷰 생성(같은 이름 있으면 만들 수 없음. 카테고리 필수)
    public ResponseEntity<?> createSellerReview(@RequestBody SellerReviewRegister sellerReviewRegister){
        try{SellerReview sellerReview= sellerReviewService.createSellerReview(sellerReviewRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(sellerReview);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[3]

        @GetMapping("/get/{sellerReviewNumber}")//판매자 리뷰 정보 가져옴
        public ResponseEntity<SellerReview>getConsumerReview(@PathVariable Long sellerReviewNumber){
            SellerReview sellerReview= sellerReviewService.getSellerReview(sellerReviewNumber);
            if(sellerReview!=null){return ResponseEntity.ok(sellerReview);
            }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

        @GetMapping("/getAll") public List<SellerReview> getAllSellerReviews(){//모든 판매자 리뷰 정보 가져옴
            List<SellerReview> sellerReview=sellerReviewService.getAllSellerReviews();
            sellerReview.forEach(System.out::println);return sellerReview;}//[40]

    @PutMapping("/change/{sellerReviewNumber}")//판매자 리뷰 수정(같은 이름 있으면 만들 수 없음. 카테고리 필수)
    public ResponseEntity<?>changeSellerReview(@PathVariable Long sellerReviewNumber,
                                               @RequestBody SellerReviewRegister sellerReviewRegister){

        try{SellerReview changeSellerReview= sellerReviewService.changeSellerReview
                (sellerReviewNumber,sellerReviewRegister);return ResponseEntity.ok(changeSellerReview);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
                ("잘못된 요청 -"+e.getMessage());}}

        @DeleteMapping("/delete/{sellerReviewNumber}")//판매자 리뷰 삭제
        public void deleteSellerReview(@PathVariable Long sellerReviewNumber){
            sellerReviewService.deleteSellerReview(sellerReviewNumber);}}//[4][31][32][33][34]