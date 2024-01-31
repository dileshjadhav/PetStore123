package com.itvedant.petstore123.Entities;

import java.time.Instant;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.itvedant.petstore123.Repository.ProductRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Name should not be Null")
    @NotEmpty(message = "Name should contain data")
    @Length(min = 3,max = 20, message = "Name should be the 20 letter.")
    private String name;

    @NotNull(message = "price should not be null")
    @Min(value = 1,message = "price should not be less than 1")
    @Max(value = 10000,message = "price should not be greater than 10000")
    private double price;

    @NotNull(message = "Description should not be Null")
    @NotEmpty(message = "Description should contain data")
    @Length(min = 10,max = 100,message = "Description should have 1 to 100 characters only")
    private String description;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private Instant creationTime;

    @LastModifiedDate
    private Instant updationTime;
    
    @ManyToOne
    @JoinColumn(name = "category_id") //owner entity
    private Category category;
    
    @ManyToMany
    @JoinTable(name = "product_orders",joinColumns = @JoinColumn(name="product_id"),
                              inverseJoinColumns = @JoinColumn(name="order_id"))
    private java.util.List<OrderDetails> orders;

    private String imageUrl;
    
    // @Size(min = 1,max = 3,message = "Category shjould have 1 to 3 atleast only")
    // private java.util.List<String> category;


    // //@Past
    // //@PastOrPresent
    // //@Future
    // @FutureOrPresent
    // private LocalDate manufactureddDate;
}

