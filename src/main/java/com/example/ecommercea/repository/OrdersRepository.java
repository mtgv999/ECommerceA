package com.example.ecommercea.repository;
import com.example.ecommercea.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {//주문
    @Query("select o from Orders o JOIN FETCH o.consumer " +
"c JOIN FETCH o.ordersItems i where o.ordersNumber = :ordersNumber")
    Optional<Orders> findByIdWithConsumer(@Param("ordersNumber") Long ordersNumber);

    @Query("SELECT o FROM Orders o JOIN FETCH o.ordersItems WHERE o.ordersNumber = :ordersNumber")
    Optional<Orders> findOrdersWithItems(@Param("ordersNumber") Long ordersNumber);//[20][21]

    boolean existsByOrdersName(String ordersName);//주문 이름으로 중복된 상품이 있는지 여부 확인
    Orders findByOrdersNumber(Long ordersNumber);//주문 ID로 해당 상품 찾기
    void deleteByOrdersNumber(Long ordersNumber);}//주문 ID로 해당 상품 찾아 삭제