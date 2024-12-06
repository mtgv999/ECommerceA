package com.example.ecommercea;
public class DuplicateNameException extends RuntimeException{//이름 중복 예외
    public DuplicateNameException(String message){super(message);}}