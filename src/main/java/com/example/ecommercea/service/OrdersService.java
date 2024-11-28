package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Orders;
import com.example.ecommercea.register.OrdersRegister;
import com.example.ecommercea.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public Orders createOrders(OrdersRegister ordersRegister){
        if(ordersRepository.existsByOrdersName(ordersRegister.getOrdersName())){
            throw new DuplicateNameException("주문 이름 이미 있음");}
        return ordersRepository.save(OrdersRegister.ordersForm(ordersRegister));}//[3]

    public Orders getOrders(Long ordersID){
        return ordersRepository.findById(ordersID).orElse(null);}

    public Orders changeOrders(Long ordersID, OrdersRegister ordersRegister){
        Orders saved= ordersRepository.findById(ordersID)
                .orElseThrow(()->new RuntimeException("주문 없음"));
        saved.ordersChange(ordersRegister);return saved;}//[4]

    public void deleteOrders(Long ordersID){
        ordersRepository.deleteByOrdersNumber(ordersID);}}