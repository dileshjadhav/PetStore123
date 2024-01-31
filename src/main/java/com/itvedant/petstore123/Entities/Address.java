package com.itvedant.petstore123.Entities;

import java.time.Instant;

import org.apache.catalina.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Address {
   
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String city;
    private String state;
    private String country;

    @CreatedDate
    private Instant creationtime;
     @LastModifiedDate
    private Instant updationtime;

    //address entity is my INverse entity.
    @OneToOne(mappedBy = "address")
    private com.itvedant.petstore123.Entities.User user;
    
}
    

