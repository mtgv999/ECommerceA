package com.example.ecommercea.repository;
import com.example.ecommercea.domain.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,Long> {//소비자
    boolean existsByConsumerName(String ConsumerName);//소비자 이름으로 중복된 소비자 계정이 있는지 여부 확인
    Consumer findByConsumerName(String ConsumerName);//소비자 이름으로 중복된 소비자 계정 찾기
    Consumer findByConsumerID(Long ConsumerID);//소비자 ID로 해당 소비자 계정 찾기
    Consumer deleteByConsumerID(Long ConsumerID);}//소비자 ID로 해당 소비자 계정 찾아 삭제
