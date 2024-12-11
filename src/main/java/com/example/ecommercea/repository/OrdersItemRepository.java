package com.example.ecommercea.repository;
import com.example.ecommercea.domain.OrdersItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface OrdersItemRepository extends JpaRepository<OrdersItem,Long> {}
    //@Query("SELECT i FROM OrdersItem i JOIN FETCH i.consumerID where i.ordersItemID = :orders")
    //Optional<OrdersItem>findByIdWithConsumer2(@Param("ordersItemID") Long ordersItemID);}//[6]~[18],[28]