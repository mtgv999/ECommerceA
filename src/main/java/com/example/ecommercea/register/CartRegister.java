package com.example.ecommercea.register;
import com.example.ecommercea.domain.Cart;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CartRegister {//장바구니 등록
    private Long cartID;//장바구니 ID [40]
    private String cartName;//장바구니 이름
    private String productName;//상품 이름

    private Long sellerID;//판매자
    private Long consumerID;//고객
    private int cartStock;//장바구니 내 상품의 총 개수

    private Long totalCost;//가격 총합
    private Long cartNumber;//장바구니 번호
    private Long productID;//상품 ID

    public static Cart cartForm(CartRegister cartRegister){
        return Cart.builder().cartName(cartRegister.getCartName())
                .productName(cartRegister.getProductName())

                .sellerID(cartRegister.getSellerID())
                .consumerID(cartRegister.getConsumerID())
                .cartStock(cartRegister.getCartStock())

                .totalCost(cartRegister.getTotalCost())
                .cartNumber(cartRegister.getCartNumber())
                .productID(cartRegister.getProductID()).build();}}