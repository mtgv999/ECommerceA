package com.example.ecommercea.repository;
import com.example.ecommercea.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SellerRepository extends JpaRepository<Seller,Long> {//판매자
    boolean existsBySellerName(String sellerName);//판매자 이름으로 중복된 판매자 계정이 있는지 여부 확인
    Seller findBySellerName(String sellerName);//판매자 이름으로 중복된 판매자 계정 찾기
    Seller findBySellerID(String sellerID);//판매자 ID로 해당 판매자 계정 찾기
    void deleteBySellerID(String sellerID);}//판매자 ID로 해당 판매자 계정 찾아 삭제


