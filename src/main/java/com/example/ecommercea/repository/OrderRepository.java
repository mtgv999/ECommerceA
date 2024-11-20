package com.example.ecommercea.repository;
import com.example.ecommercea.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {//주문
    boolean existsByOrderName(String orderName);//주문 이름으로 중복된 주문인지 여부 확인
    Order findByOrderNumber(String orderNumber);//주문 번호로 해당 주문 찾기
    void deleteByOrderNumber(Long orderNumber);}//주문 번호로 해당 주문 찾아 삭제