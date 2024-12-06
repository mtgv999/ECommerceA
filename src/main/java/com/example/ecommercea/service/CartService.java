package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Cart;
import com.example.ecommercea.register.CartRegister;

import com.example.ecommercea.repository.CartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {//장바구니
    private final CartRepository cartRepository;

    public Cart createCart(CartRegister cartRegister){
        if(cartRepository.existsByCartName(cartRegister.getCartName())){
            throw new DuplicateNameException("소비자 이름 이미 있음");}
        return cartRepository.save(CartRegister.cartForm(cartRegister));}

    public Cart getCart(Long cartID){
        return cartRepository.findById(cartID).orElse(null);}

    public Cart changeCart(Long cartID, CartRegister cartRegister){
        Cart saved= cartRepository.findById(cartID)
                .orElseThrow(()->new RuntimeException("소비자 없음"));
        saved.cartChange(cartRegister);return saved;}

    public void deleteCart(Long cartID){
        cartRepository.deleteByCartID(cartID);}}