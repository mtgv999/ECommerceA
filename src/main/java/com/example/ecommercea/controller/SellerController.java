package com.example.ecommercea.controller;

import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Seller;
import com.example.ecommercea.register.SellerRegister;
import com.example.ecommercea.request.SellerDeleteRequest;
import com.example.ecommercea.request.SellerLoginRequest;
import com.example.ecommercea.service.SellerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

        @PostMapping("/create")
        public ResponseEntity<?> createSeller(@RequestBody SellerRegister sellerRegister){
            try {Seller seller= sellerService.createSeller(sellerRegister);
                return ResponseEntity.status(HttpStatus.CREATED).body(seller);
            }catch (DuplicateNameException e){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[3]

        @PostMapping("/login")
        //판매자가 로그인을 하려고 할 때, 판매자 이름, PW를 확인 한 후에 로그인
        public ResponseEntity<String> loginSeller
                (HttpSession session, @RequestBody SellerLoginRequest sellerLoginRequest) {
            Seller seller = sellerService.authenticateSeller(sellerLoginRequest);

            if (seller != null) {//세션에 판매자 ID 저장.
                session.setAttribute("sellerID", seller.getSellerID());
                return ResponseEntity.ok("로그인 성공");
            }else{return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED).body("로그인 실패");}}

        @PostMapping("/logout")//판매자용 로그아웃
        public ResponseEntity<String> logoutSeller(HttpSession session) {//세션 무효화
            session.invalidate();return ResponseEntity.ok("로그아웃 성공");}

        @GetMapping("/profile")//로그인된 판매자 프로필 정보 가져옴
        public ResponseEntity<Seller> getProfile(HttpSession session){
            Long sellerID=(Long)session.getAttribute("sellerID");

            if(sellerID==null){return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();}
            Optional<Seller> seller= sellerService.findBySellerID(sellerID);
            return seller.map(ResponseEntity::ok).orElseGet(()
                    ->ResponseEntity.notFound().build());}

        @GetMapping("/get/{sellerID}")//판매자 정보 가져옴
        public ResponseEntity<Seller>getSeller(@PathVariable Long sellerID){
            Seller seller= sellerService.getSeller(sellerID);
            if(seller!=null){return ResponseEntity.ok(seller);
            }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

        @PutMapping("/change/{sellerID}")//소비자 정보 수정
        public ResponseEntity<Seller> changeSeller(@PathVariable Long sellerID,
                                                     @RequestBody SellerRegister sellerRegister){

            try{Seller changeSeller= sellerService.changeSeller(sellerID,sellerRegister);
                return ResponseEntity.ok(changeSeller);
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}//[4]

        @DeleteMapping("/delete/{sellerID}")
        //소비자 계정을 삭제하려고 할 때, 고객 ID, PW를 확인한 후에 삭제.
        public ResponseEntity<String> deleteSeller(@PathVariable Long sellerID,
    @RequestBody SellerDeleteRequest sellerDeleteRequest){

            try {sellerService.deleteSeller(sellerID,sellerDeleteRequest);
                return ResponseEntity.ok("소비자 계정을 성공적 으로 삭제");
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body
                        ("소비자 ID 삭제 실패 또는 발견 안 됨.");}}}//[5]*/