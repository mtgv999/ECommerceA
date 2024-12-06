package com.example.ecommercea.domain;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
@Getter
@MappedSuperclass
@EntityListeners(value ={AuditingEntityListener.class})
public class BaseEntity{
    @CreatedDate//만든 시간
    private LocalDateTime createdTime=LocalDateTime.now();
    @LastModifiedDate//업데이트한 시간
    private LocalDateTime updatedTime=LocalDateTime.now();}