package com.example.ecommercea.repository;
import com.example.ecommercea.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {//주문
    boolean existsByOrdersName(String ordersName);//주문 이름으로 중복된 상품이 있는지 여부 확인
    Orders findByOrdersNumber(Long ordersNumber);//주문 ID로 해당 상품 찾기
    void deleteByOrdersNumber(Long ordersNumber);}//주문 ID로 해당 상품 찾아 삭제