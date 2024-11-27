package com.example.ecommercea.register;
import com.example.ecommercea.domain.Consumer;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ConsumerRegister {//소비자용 회원등록

    private String consumerName;
    private String consumerPW;
    private Long consumerAccountNumber;
    private Long consumerPhoneNumber;
    private String consumerReview;

    public static Consumer consumerForm(ConsumerRegister consumerRegister){
        return Consumer.builder().consumerName(consumerRegister.getConsumerName())
        .consumerPW(consumerRegister.getConsumerPW())
        .consumerAccountNumber(consumerRegister.getConsumerAccountNumber())
        .consumerPhoneNumber(consumerRegister.getConsumerPhoneNumber())
        .consumerReview(consumerRegister.getConsumerReview()).build();}}