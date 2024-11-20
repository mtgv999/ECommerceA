package com.example.ecommercea.service;
import com.example.ecommercea.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@Transactional
@RequiredArgsConstructor
public class ProductService{//상품
    private final ProductRepository productRepository;
    public void deleteProduct(Long productID){
        productRepository.deleteByProductID(productID);}}
