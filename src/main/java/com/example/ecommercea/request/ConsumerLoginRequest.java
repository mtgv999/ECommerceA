package com.example.ecommercea.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerLoginRequest {//소비자 로그인 확인 요청
    @JsonProperty
    private String consumerName;
    @JsonProperty
    private String consumerPW;}