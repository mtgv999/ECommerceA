package com.example.ecommercea.repository;
import com.example.ecommercea.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {//주문
    boolean existsByOrdersName(String orderName);//주문 이름으로 중복된 주문인지 여부 확인
    Orders findByOrdersNumber(String orderNumber);//주문 번호로 해당 주문 찾기
    void deleteByOrdersNumber(Long orderNumber);}//주문 번호로 해당 주문 찾아 삭제