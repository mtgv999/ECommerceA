//package com.example.ecommercea.controller;
//
//import com.example.ecommercea.service.ProductService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/product")
//public class ProductController {
//    private final ProductService productService;
//    @DeleteMapping("/delete/{productID}")//상품 삭제
//    public void deleteProduct(@PathVariable Long productID){
//        productService.deleteProduct(productID);}}