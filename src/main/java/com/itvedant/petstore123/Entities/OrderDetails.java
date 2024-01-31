package com.itvedant.petstore123.Entities;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDate orderDate;
    private Double totalamount;

    @CreatedDate
    private Instant creationtime;
    @LastModifiedDate
    private Instant updationtime;
     
   @ManyToMany(mappedBy = "orders") 
    private List<Product> productsordered;


    
}

