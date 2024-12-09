package com.example.ecommercea.repository;
import com.example.ecommercea.domain.OrdersItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrdersItemRepository extends JpaRepository<OrdersItem,Long> { }//[6]~[18]