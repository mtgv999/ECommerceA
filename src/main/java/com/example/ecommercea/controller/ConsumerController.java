package com.example.ecommercea.controller;

import com.example.ecommercea.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ConsumerController {//소비자
    private final ConsumerService consumerService;
    @PostMapping
}
