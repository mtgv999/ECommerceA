package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Consumer;
import com.example.ecommercea.register.ConsumerRegister;
import com.example.ecommercea.repository.ConsumerRepository;
import com.example.ecommercea.request.ConsumerDeleteRequest;
import com.example.ecommercea.request.ConsumerLoginRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ConsumerService {//소비자
    private final ConsumerRepository consumerRepository;
    public Consumer createConsumer(ConsumerRegister consumerRegister){//소비자 계정 생성
        if(consumerRepository.existsByConsumerName(consumerRegister.getConsumerName())){
            throw new DuplicateNameException("소비자 이름 이미 있음");}
        return consumerRepository.save(ConsumerRegister.consumerForm(consumerRegister));}

    public Consumer authenticateConsumer(ConsumerLoginRequest consumerLoginRequest){
        //소비자 인증 - 소비자가 로그인을 하려고 할 때, 소비자 이름, PW 확인한 후에 로그인
        Consumer consumer=consumerRepository.findByConsumerName
                (consumerLoginRequest.getConsumerName());

        if(consumer.getConsumerPW().equals(consumerLoginRequest.getConsumerPW())
            &&consumer.getConsumerName().equals(consumerLoginRequest.getConsumerName()))
        {return consumer;}return null;}

    public void logoutConsumer(HttpSession session)//소비자용 로그아웃
    {session.invalidate();}

    public Optional<Consumer>findByConsumerID(Long consumerID){
        //소비자 ID로 중복된 계정 찾기
        return consumerRepository.findById(consumerID);}

    public Consumer getConsumer(Long consumerID){//소비자 정보 가져옴
        return consumerRepository.findById(consumerID).orElse(null);}

    public Consumer changeConsumer(Long consumerID, ConsumerRegister consumerRegister){//소비자 정보 수정
        Consumer saved=consumerRepository.findById(consumerID)
                .orElseThrow(()->new RuntimeException("소비자 없음"));

        if(consumerRepository.existsByConsumerName(consumerRegister.getConsumerName())){
            throw new DuplicateNameException("소비자 이미 있음");}
        saved.consumerChange(consumerRegister);return consumerRepository.save(saved);}//[4][31][32][33][34]

    public void deleteConsumer(Long consumerID, ConsumerDeleteRequest consumerDeleteRequest){//소비자 계정 삭제
        Consumer consumer=consumerRepository.findById(consumerID)
                .orElseThrow(()->new RuntimeException("소비자 없음"));

        if(consumer.getConsumerPW().equals(consumerDeleteRequest.getConsumerPW())&&
        consumer.getConsumerName().equals(consumerDeleteRequest.getConsumerName())){
            consumerRepository.deleteById(consumerID);}
        else throw new RuntimeException("소비자 ID 삭제 실패 또는 발견 안 됨");}}//[5][36][37][38]