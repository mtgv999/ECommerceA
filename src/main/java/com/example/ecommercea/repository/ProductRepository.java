package com.example.ecommercea.repository;
import com.example.ecommercea.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {//상품
    boolean existsByProductName(String productName);//상품 이름으로 중복된 상품이 있는지 여부 확인
    Product findByProductID(Long productID);//상품 ID로 해당 상품 찾기
    void deleteByProductID(Long productID);}//상품 ID로 해당 상품 찾아 삭제