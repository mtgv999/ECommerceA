package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Product;

import com.example.ecommercea.register.ProductRegister;
import com.example.ecommercea.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService{//상품
    private final ProductRepository productRepository;

    public Product createProduct(ProductRegister productRegister){//상품 생성
        if(productRepository.existsByProductName(productRegister.getProductName())){
            throw new DuplicateNameException("상품 이름 이미 있음");}
        return productRepository.save(ProductRegister.productForm(productRegister));}

    public Product getProduct(Long productID){//상품 정보 가져옴
        return productRepository.findById(productID).orElse(null);}

    public List<Product>getAllProducts(){//모든 상품 정보 가져옴
        return productRepository.findAll();}//[40]

    public Product changeProduct(Long productID, ProductRegister productRegister){
        Product saved= productRepository.findById(productID)
                .orElseThrow(()->new RuntimeException("상품 없음"));

        if(productRepository.existsByProductName(productRegister.getProductName())){
    throw new DuplicateNameException("상품 이름 이미 있음.");}
        saved.productChange(productRegister);return productRepository.save(saved);}

    public void deleteProduct(Long productID){//상품 삭제
        productRepository.deleteByProductID(productID);}}