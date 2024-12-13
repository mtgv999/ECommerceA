package com.example.ecommercea.register;
import com.example.ecommercea.domain.Product;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProductRegister {//상품 등록
    private Long productID;//상품 ID [40]
    private String productName;//상품 이름
    private Long sellerID;//판매자 ID
    private Long cost;//가격

    private String category;//분류
    private String information;//정보
    private String productNumber;//상품 번호
    private int stock;//상품 개수

    public static Product productForm(ProductRegister productRegister){
        return Product.builder().
                productName(productRegister.getProductName())
                .sellerID(productRegister.getSellerID())
                .cost(productRegister.getCost())
                .category(productRegister.getCategory())
                .information(productRegister.getInformation())
                .productNumber(productRegister.getProductNumber())
                .stock(productRegister.getStock()).build();}}