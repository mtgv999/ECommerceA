package com.example.ecommercea.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SellerDeleteRequest {//판매자 계정 삭제 요청
    @JsonProperty
    private Long sellerID;//판매자 ID
    @JsonProperty
    private String sellerPW;}//판매자 비밀번호
