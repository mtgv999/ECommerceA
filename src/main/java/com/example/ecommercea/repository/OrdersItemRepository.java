package com.example.ecommercea.repository;
import com.example.ecommercea.domain.Orders;
import com.example.ecommercea.domain.OrdersItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface OrdersItemRepository extends JpaRepository<OrdersItem,Long> {
    List<OrdersItem>findByOrders_OrdersNumber(Long ordersNumber);}//특정 주문 번호로 주문 항목 조회 [39]
    //@Query("SELECT i FROM OrdersItem i JOIN FETCH i.consumerID where i.ordersItemID = :orders")
    //Optional<OrdersItem>findByIdWithConsumer2(@Param("ordersItemID") Long ordersItemID);}//[6]~[18],[28]