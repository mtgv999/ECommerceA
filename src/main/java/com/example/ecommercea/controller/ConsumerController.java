package com.example.ecommercea.controller;
import com.example.ecommercea.DuplicateNameException;
import com.example.ecommercea.domain.Consumer;
import com.example.ecommercea.register.ConsumerRegister;
import com.example.ecommercea.request.ConsumerDeleteRequest;
import com.example.ecommercea.request.ConsumerLoginRequest;
import com.example.ecommercea.service.ConsumerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/consumer")
@RequiredArgsConstructor
public class ConsumerController {//소비자
    private final ConsumerService consumerService;
        @PostMapping("/create")//소비자 회원가입
        public ResponseEntity<?> createConsumer(@RequestBody ConsumerRegister consumerRegister){
            try {Consumer consumer=consumerService.createConsumer(consumerRegister);
                return ResponseEntity.status(HttpStatus.CREATED).body(consumer);
            }catch (DuplicateNameException e){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[3]

        @PostMapping("/login")
        //소비자가 로그인을 하려고 할 때, 소비자 이름, PW를 확인 한 후에 로그인
        public ResponseEntity<String> loginConsumer
        (HttpSession session, @RequestBody ConsumerLoginRequest consumerLoginRequest) {
            Consumer consumer = consumerService.authenticateConsumer(consumerLoginRequest);

            if (consumer != null) {//세션에 소비자 ID 저장.
                session.setAttribute("consumerID", consumer.getConsumerID());
            return ResponseEntity.ok("로그인 성공");
        }else{return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED).body("로그인 실패");}}

        @PostMapping("/logout")//소비자용 로그아웃
        public ResponseEntity<String> logoutConsumer(HttpSession session) {//세션 무효화
            session.invalidate();return ResponseEntity.ok("로그아웃 성공");}

        @GetMapping("/profile")//로그인된 소비자 프로필 정보 가져옴
        public ResponseEntity<Consumer> getProfile(HttpSession session){
            Long consumerID=(Long)session.getAttribute("customerID");

        if(consumerID==null){return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();}
            Optional<Consumer>consumer=consumerService.findByConsumerID(consumerID);
        return consumer.map(ResponseEntity::ok).orElseGet(()
        ->ResponseEntity.notFound().build());}

        @GetMapping("/get/{consumerID}")//소비자 정보 가져옴
        public ResponseEntity<Consumer>getConsumer(@PathVariable Long consumerID){
            Consumer consumer=consumerService.getConsumer(consumerID);
            if(consumer!=null){return ResponseEntity.ok(consumer);
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

        @PutMapping("/change/{consumerID}")//소비자 정보 수정
        public ResponseEntity<Consumer>changeConsumer(@PathVariable Long consumerID,
            @RequestBody ConsumerRegister consumerRegister){

        try{Consumer changeConsumer=consumerService.changeConsumer(consumerID,consumerRegister);
        return ResponseEntity.ok(changeConsumer);
            }catch (Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}//[4]

            @DeleteMapping("/delete/{consumerID}")
            //소비자 계정을 삭제하려고 할 때, 고객 ID, PW를 확인한 후에 삭제.
            public ResponseEntity<String> deleteConsumer(@PathVariable Long consumerID,
            @RequestBody ConsumerDeleteRequest consumerDeleteRequest){

            try {consumerService.deleteSeller(consumerID,consumerDeleteRequest);
                return ResponseEntity.ok("소비자 계정을 성공적 으로 삭제");
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body
                        ("소비자 ID 삭제 실패 또는 발견 안 됨.");}}}//[5]