package com.itvedant.petstore123.Entities;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.itvedant.petstore123.Validator.Mobile;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "First name is required")
    @NotEmpty(message = "Not be empty")
    private String firstName;
    
    @NotNull(message = "last name is required")
    @NotEmpty(message = "Not be empty")
    private String lastName;
    
    
    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email should Not be empty")
    private String email;
    
    @Mobile
    private String mobile;

    private String password;
    private String confirmpassword;
    @CreatedDate
    private Instant creationTime;
    @LastModifiedDate
     private Instant updationTime;

    @OneToOne
    @JoinColumn(name = "addr_id") //@joincolum automatically dclaRE OWNER ENTITY.
    private Address address;
}
