package com.example.ecommercea.repository;
import com.example.ecommercea.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    boolean existsByOrdersName(String ordersName);
    //상품 이름으로 중복된 상품이 있는지 여부 확인
    Orders findByOrdersNumber(Long ordersNumber);//상품 ID로 해당 상품 찾기
    void deleteByOrdersNumber(Long ordersNumber);}//상품 ID로 해당 상품 찾아 삭제