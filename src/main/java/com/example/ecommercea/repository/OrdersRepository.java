package com.example.ecommercea.repository;
import com.example.ecommercea.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {//주문

    @Query("SELECT o FROM Orders o JOIN FETCH o.ordersItems WHERE o.ordersNumber = :ordersNumber")
        //주문 내에서 주문한 물품 조회
    Optional<Orders> findOrdersWithItems(@Param("ordersNumber") Long ordersNumber);//[20][21]

    List<Orders> findByConsumerID(Long consumerID);//특정 소비자 ID로 주문 조회[39]

    boolean existsByOrdersName(String ordersName);//주문 이름으로 중복된 상품이 있는지 여부 확인

    Orders findByOrdersNumber(Long ordersNumber);//주문 ID로 해당 상품 찾기

    void deleteByOrdersNumber(Long ordersNumber);//주문 ID로 해당 상품 찾아 삭제

    @Query("SELECT o FROM Orders o LEFT JOIN FETCH o.ordersItems")
    List<Orders> findAllWithItems();}//모든 주문과 주문 내 모든 상품들 정보 가져옴 [41]~[43] 특히 [43] [5]