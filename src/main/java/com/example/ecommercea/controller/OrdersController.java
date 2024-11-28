package com.example.ecommercea.controller;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Orders;
import com.example.ecommercea.register.OrdersRegister;
import com.example.ecommercea.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrders(@RequestBody OrdersRegister ordersRegister){
        try {Orders orders= ordersService.createOrders(ordersRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(orders);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[3]

    @GetMapping("/get/{ordersNumber}")//소비자 정보 가져옴
    public ResponseEntity<Orders>getOrders(@PathVariable Long ordersNumber){
        Orders orders= ordersService.getOrders(ordersNumber);
        if(orders!=null){return ResponseEntity.ok(orders);
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @PutMapping("/change/{ordersNumber}")//소비자 정보 수정
    public ResponseEntity<Orders>changeOrders(@PathVariable Long ordersNumber,
                                 @RequestBody OrdersRegister ordersRegister){

        try{Orders changeOrders= ordersService.changeOrders(ordersNumber,ordersRegister);
            return ResponseEntity.ok(changeOrders);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}//[4]

    @DeleteMapping("/delete/{ordersNumber}")//상품 삭제
    public void deleteOrders(@PathVariable Long ordersNumber){
        ordersService.deleteOrders(ordersNumber);}}