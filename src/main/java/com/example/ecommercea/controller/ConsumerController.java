package com.example.ecommercea.controller;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Consumer;
import com.example.ecommercea.register.ConsumerRegister;
import com.example.ecommercea.service.ConsumerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ConsumerController {//소비자
    private final ConsumerService consumerService;
        @PostMapping("/create")
        public ResponseEntity<?> createConsumer(@RequestBody ConsumerRegister consumerRegister){
            try {Consumer consumer=consumerService.createConsumer(consumerRegister);
                return ResponseEntity.status(HttpStatus.CREATED).body(consumer);
            }catch (DuplicateNameException e){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}

        @PostMapping("/login")
        //소비자가 로그인을 하려고 할 때, 소비자 이름, PW를 확인 한 후에 로그인
        public ResponseEntity<String> loginConsumer
        (HttpSession session, @RequestBody )
    }
}