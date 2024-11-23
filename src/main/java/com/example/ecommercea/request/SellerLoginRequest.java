package com.example.ecommercea.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SellerLoginRequest {//판매자 로그인 여부 확인 요쳥
    @JsonProperty
    private Long sellerID;
    @JsonProperty
    private String sellerPW;}