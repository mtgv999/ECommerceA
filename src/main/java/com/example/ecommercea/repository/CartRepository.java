//package com.example.ecommercea.repository;
//import com.example.ecommercea.domain.Cart;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//@Repository
//public interface CartRepository extends JpaRepository<Cart,Long> {//장바구니
//    boolean existsByCartName(String cartName);//장바구니 이름으로 중복된 장바구니가 있는지 여부 확인
//    Cart findByCartID(Long cartID);//장바구니 ID로 해당 장바구니 찾기
//    void deleteByCartID(Long cartID);}//장바구니 ID로 해당 장바구니 찾아 삭제