package com.example.ecommercea.register;
import com.example.ecommercea.domain.Consumer;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ConsumerRegister {//소비자용 회원등록
    private String consumerName;//소비자 이름
    private String consumerPW;//소비자 비밀번호
    private String consumerAccountNumber;//소비자 계좌번호
    private String consumerPhoneNumber;//소비자 전화번호
    private String consumerReview;//소비자 리뷰

    public static Consumer consumerForm(ConsumerRegister consumerRegister){
        return Consumer.builder().consumerName(consumerRegister.getConsumerName())
        .consumerPW(consumerRegister.getConsumerPW())
        .consumerAccountNumber(consumerRegister.getConsumerAccountNumber())
        .consumerPhoneNumber(consumerRegister.getConsumerPhoneNumber())
        .consumerReview(consumerRegister.getConsumerReview()).build();}}