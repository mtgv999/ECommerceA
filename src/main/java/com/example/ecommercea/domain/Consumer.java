package com.example.ecommercea.domain;
import com.example.ecommercea.register.ConsumerRegister;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
@Setter
public class Consumer extends BaseEntity{@Id//소비자
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consumerID;//소비자 아이디
    private String consumerName;//소비자 이름
    private String consumerPW;//소비자 비밀 번호
    private Long consumerAccountNumber;//소비자 계좌 번호
    private Long consumerPhoneNumber;//소비자 휴대폰 번호
    private String consumerReview;//소비자 리뷰

    public void consumerChange(ConsumerRegister consumerRegister){
        this.consumerName=consumerRegister.getConsumerName();
        this.consumerPW=consumerRegister.getConsumerPW();
        this.consumerAccountNumber=consumerRegister.getConsumerAccountNumber;
        this.consumerPhoneNumber=consumerRegister.getConsumerPhoneNumber();
        this.consumerReview=consumerRegister.getConsumerReview();}}//[3]