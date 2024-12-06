package com.example.ecommercea.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerLoginRequest {//소비자 로그인 여부 확인 요청
    @JsonProperty
    private String consumerName;//소비자 이름
    @JsonProperty
    private String consumerPW;}//소비자 PW