package com.example.ecommercea.repository;
import com.example.ecommercea.domain.OrdersItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface OrdersItemRepository extends JpaRepository<OrdersItem,Long> {
    List<OrdersItem>findByOrders_OrdersNumber(Long ordersNumber);}//특정 주문 번호를 통해 주문 항목 조회 [39]