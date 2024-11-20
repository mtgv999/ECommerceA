package com.example.ecommercea.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerDeleteRequest {//소비자 계정 삭제 요청
    @JsonProperty
    private Long consumerID;
    @JsonProperty
    private Long consumerPW;}