package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Cart;
import com.example.ecommercea.register.CartRegister;

import com.example.ecommercea.repository.CartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {//장바구니
    private final CartRepository cartRepository;

    public Cart createCart(CartRegister cartRegister){//장바구니 생성
        if(cartRepository.existsByCartName(cartRegister.getCartName())){
            throw new DuplicateNameException("소비자 이름 이미 있음");}
        return cartRepository.save(CartRegister.cartForm(cartRegister));}

    public Cart getCart(Long cartID){//장바구니 정보 가져옴
        return cartRepository.findById(cartID).orElse(null);}

    public List<Cart>getAllCarts(){//모든 장바구니 정보 가져옴.
        return cartRepository.findAll();}//[40]

    public Cart changeCart(Long cartID, CartRegister cartRegister){//장바구니 정보 수정
        Cart saved= cartRepository.findById(cartID)
                .orElseThrow(()->new RuntimeException("소비자 없음"));

        if(cartRepository.existsByCartName(cartRegister.getCartName())){
            throw new DuplicateNameException("장바구니 이미 있음");}
        saved.cartChange(cartRegister);return cartRepository.save(saved);}

    public void deleteCart(Long cartID){//장바구니 삭제
        cartRepository.deleteByCartID(cartID);}}