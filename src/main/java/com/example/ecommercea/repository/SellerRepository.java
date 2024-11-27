package com.example.ecommercea.repository;
import com.example.ecommercea.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    boolean existsBySellerName(String SellerName);//소비자 이름으로 중복된 소비자 계정이 있는지 여부 확인
    Seller findBySellerName(String SellerName);//소비자 이름으로 중복된 소비자 계정 찾기
    Seller findBySellerID(Long SellerID);//소비자 ID로 해당 소비자 계정 찾기
    Seller deleteBySellerID(Long SellerID);}//소비자 ID로 해당 소비자 계정 찾아 삭제