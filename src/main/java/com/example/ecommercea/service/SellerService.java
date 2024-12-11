package com.example.ecommercea.service;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Seller;
import com.example.ecommercea.register.SellerRegister;
import com.example.ecommercea.repository.SellerRepository;
import com.example.ecommercea.request.SellerDeleteRequest;
import com.example.ecommercea.request.SellerLoginRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerService {//판매자
    private final SellerRepository sellerRepository;
    public Seller createSeller(SellerRegister sellerRegister){
        if(sellerRepository.existsBySellerName(sellerRegister.getSellerName())){
            throw new DuplicateNameException("소비자 이름 이미 있음");}
        return sellerRepository.save(SellerRegister.sellerForm(sellerRegister));}

    public Seller authenticateSeller(SellerLoginRequest sellerLoginRequest){
        //판매자 인증 - 소비자가 로그인을 하려고 할 때, 소비자 이름, PW 확인한 후에 로그인
        Seller seller= sellerRepository.findBySellerName
                (sellerLoginRequest.getSellerName());

        if(seller.getSellerPW().equals(sellerLoginRequest.getSellerPW())
                &&seller.getSellerName().equals(sellerLoginRequest.getSellerName()))
        {return seller;}return null;}

    public void logoutSeller(HttpSession session)//판매자용 로그아웃
    {session.invalidate();}

    public Optional<Seller> findBySellerID(Long sellerID){
        //소비자 ID로 중복된 계정 찾기
        return sellerRepository.findById(sellerID);}

    public Seller getSeller(Long sellerID){
        return sellerRepository.findById(sellerID).orElse(null);}

    public Seller changeSeller(Long sellerID, SellerRegister sellerRegister){
        Seller saved= sellerRepository.findById(sellerID)
                .orElseThrow(()->new RuntimeException("판매자 없음"));

        if(sellerRepository.existsBySellerName(sellerRegister.getSellerName())){
            throw new DuplicateNameException("판매자 이름 이미 있음");}
        saved.sellerChange(sellerRegister);return sellerRepository.save(saved);}//[4][31][32][33][34]

    public void deleteSeller(Long sellerID, SellerDeleteRequest sellerDeleteRequest){
        Seller seller= sellerRepository.findById(sellerID)
                .orElseThrow(()->new RuntimeException("판매자 없음"));

        if(seller.getSellerPW().equals(sellerDeleteRequest.getSellerPW())&&
        seller.getSellerName().equals(sellerDeleteRequest.getSellerName())){
            sellerRepository.deleteById(sellerID);}
        else throw new RuntimeException("판매자 ID 삭제 실패 또는 발견 안 됨");}}//[5][36][37][38]