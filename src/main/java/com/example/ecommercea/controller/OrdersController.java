package com.example.ecommercea.controller;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Orders;
import com.example.ecommercea.register.OrdersRegister;
import com.example.ecommercea.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {//주문
    private final OrdersService ordersService;

    @PostMapping("/create")//주문 생성(같은 이름 있으면 만들 수 없음.)
    public ResponseEntity<?> createOrders(@RequestBody OrdersRegister ordersRegister){
        try {Orders orders= ordersService.createOrders(ordersRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(orders);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[3]

    @GetMapping("/get/{ordersNumber}")//주문 정보 가져옴
    public ResponseEntity<Orders>getOrders(@PathVariable Long ordersNumber){
        Orders orders= ordersService.getOrders(ordersNumber);
        if(orders!=null){return ResponseEntity.ok(orders);
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}//[20]~[24]

    @GetMapping("/getAll") public List<Orders> getAllOrders(){//모든 주문 저옵 가져옴
        List<Orders> orders=ordersService.getAllOrders();
        orders.forEach(System.out::println);return orders;}//[40]

    @GetMapping("/customer/{customerID}")
    //소비자 계정으로 누가 어떤 주문을 했는지 어떤 물품을 주문했는지 주문 정보를 가져옴.
    public ResponseEntity<List<OrdersRegister>> getOrdersByCustomer(@PathVariable Long customerID) {
        List<OrdersRegister> ordersOrdersRegisterList =
                ordersService.getOrdersWithItemsByCustomer(customerID);
        return ResponseEntity.ok(ordersOrdersRegisterList);}//[39]

    @GetMapping("/{ordersNumber}")//주문번호을 통해 주문한 소비자와 주문 내용 찾기
    public ResponseEntity<?>getOrdersDetails(@PathVariable Long ordersNumber){
        Map<String,Object> ordersDetails = new HashMap<>();
        return ResponseEntity.ok(ordersDetails);}//[19]~[27]

    @PutMapping("/change/{ordersNumber}")//주문 정보 수정(같은 이름 있으면 만들 수 없음.)
    public ResponseEntity<Orders>changeOrders(@PathVariable Long ordersNumber,
                                 @RequestBody OrdersRegister ordersRegister){

        try{Orders changeOrders= ordersService.changeOrders(ordersNumber,ordersRegister);
            return ResponseEntity.ok(changeOrders);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}//[4]

    @DeleteMapping("/delete/{ordersNumber}")//주문 삭제
    public void deleteOrders(@PathVariable Long ordersNumber){
        ordersService.deleteOrders(ordersNumber);}}