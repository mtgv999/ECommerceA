package com.example.ecommercea.controller;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Cart;
import com.example.ecommercea.register.CartRegister;
import com.example.ecommercea.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/create")
    public ResponseEntity<?> createCart(@RequestBody CartRegister cartRegister){
        try {Cart cart= cartService.createCart(cartRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(cart);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[3]

    @GetMapping("/get/{cartID}")//소비자 정보 가져옴
    public ResponseEntity<Cart>getCart(@PathVariable Long cartID){
        Cart cart= cartService.getCart(cartID);
        if(cart!=null){return ResponseEntity.ok(cart);
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @PutMapping("/change/{cartID}")//소비자 정보 수정
    public ResponseEntity<Cart>changeCart(@PathVariable Long cartID,
                               @RequestBody CartRegister cartRegister){

        try{Cart changeCart= cartService.changeCart(cartID,cartRegister);
            return ResponseEntity.ok(changeCart);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}//[4]

    @DeleteMapping("/delete/{cartID}")//상품 삭제
    public void deleteCart(@PathVariable Long cartID){
        cartService.deleteCart(cartID);}}