package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Product;

import com.example.ecommercea.register.ProductRegister;
import com.example.ecommercea.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService{//상품
    private final ProductRepository productRepository;

    public Product createProduct(ProductRegister productRegister){
        if(productRepository.existsByProductName(productRegister.getProductName())){
            throw new DuplicateNameException("소비자 이름 이미 있음");}
        return productRepository.save(ProductRegister.productForm(productRegister));}

    public Product getProduct(Long productID){
        return productRepository.findById(productID).orElse(null);}

    public Product changeProduct(Long productID, ProductRegister productRegister){
        Product saved= productRepository.findById(productID)
                .orElseThrow(()->new RuntimeException("소비자 없음"));
        saved.productChange(productRegister);return saved;}

    public void deleteProduct(Long productID){
        productRepository.deleteByProductID(productID);}}