package com.example.ecommercea.controller;
import lombok.RequiredArgsConstructor;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Product;

import com.example.ecommercea.register.ProductRegister;
import com.example.ecommercea.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {//상품
    private final ProductService productService;

    @PostMapping("/create")//상품 생성
    public ResponseEntity<?> createProduct(@RequestBody ProductRegister productRegister){
        try {Product product= productService.createProduct(productRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[3]

    @GetMapping("/get/{productID}")//상품 정보 가져옴
    public ResponseEntity<Product>getProduct(@PathVariable Long productID){
        Product product= productService.getProduct(productID);
        if(product!=null){return ResponseEntity.ok(product);
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @PutMapping("/change/{productID}")//상품 정보 수정
    public ResponseEntity<Product>changeProduct(@PathVariable Long productID,
     @RequestBody ProductRegister productRegister){

        try{Product changeProduct= productService.changeProduct(productID,productRegister);
            return ResponseEntity.ok(changeProduct);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}//[4]

    @DeleteMapping("/delete/{productID}")//상품 삭제
    public void deleteProduct(@PathVariable Long productID){
        productService.deleteProduct(productID);}}