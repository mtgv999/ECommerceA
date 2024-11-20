package com.example.ecommercea.register;
import com.example.ecommercea.domain.Consumer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsumerRegister {//소비자용 회원등록
    @NotNull(message = "이름 작성 필수")
    @Size(min=5)
    private String consumerName;

    @NotNull(message = "PW 작성 필수")
    @Size(min=5)
    private String consumerPW;
    private Long consumerAccountNumber;
    private Long consumerPhoneNumber;
    private String consumerReview;

    public static Consumer consumerForm(ConsumerRegister consumerRegister){
        return Consumer.builder().consumerNmae(consumerRegister.getConsumerName())
        .consumerPW(consumerRegister.getconsumerPW())
        .consumerAccountNumber(consumerRegister.getconsumerAccountNumber())
        .consumerPhoneNumber(consumerRegister.getconsumerPhoneNumber())
        .consumerReview(consumerRegister.getconsumerReview())}}