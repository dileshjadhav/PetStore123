package com.itvedant.petstore123.Entities;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Category {
     @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String name;
     @CreatedDate
     @Column(updatable = false,nullable = false)
    private Instant creationTime;
    @org.springframework.data.annotation.LastModifiedDate
    private Instant updationTime;
     
   @OneToMany(mappedBy = "category") 
    private List<Product> products;
    
}

