package com.example.ecommercea.controller;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Cart;
import com.example.ecommercea.register.CartRegister;
import com.example.ecommercea.service.CartService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {//장바구니
    private final CartService cartService;

    @PostMapping("/create")//장바구니 생성(같은 이름 있으면 만들 수 없음.)
    public ResponseEntity<?> createCart(@RequestBody CartRegister cartRegister){
        try {Cart cart= cartService.createCart(cartRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(cart);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[3]

    @GetMapping("/get/{cartID}")//장바구니 정보 가져옴(조회)
    public ResponseEntity<Cart>getCart(@PathVariable Long cartID){
        Cart cart= cartService.getCart(cartID);
        if(cart!=null){return ResponseEntity.ok(cart);
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @GetMapping("/getAll") public List<Cart> getAllCarts(){//모든 장바구니 정보 가져옴
        List<Cart> cart=cartService.getAllCarts();
        cart.forEach(System.out::println);return cart;}//[40]

    @PutMapping("/change/{cartID}")//장바구니 정보 수정(같은 이름 있으면 만들 수 없음.)
    public ResponseEntity<?>changeCart(@PathVariable Long cartID,
                               @RequestBody CartRegister cartRegister){

        try {Cart changeCart = cartService.changeCart(cartID, cartRegister);
            return ResponseEntity.ok(changeCart);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
                    ("잘못된 요청 -"+e.getMessage());}}//[4][31][32][33][34]

    @DeleteMapping("/delete/{cartID}")//장바구니 삭제
    public void deleteCart(@PathVariable Long cartID){
        cartService.deleteCart(cartID);}}