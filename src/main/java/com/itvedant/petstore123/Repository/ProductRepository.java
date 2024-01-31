package com.itvedant.petstore123.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;


import com.itvedant.petstore123.Entities.Product;

import jakarta.annotation.security.RolesAllowed;

public interface ProductRepository extends               //PagingAndSortingRepository                                                                                               //http://localhost:8080/users?sort=lastName,desc&size=2                                                               //size=2 means according to paging.
JpaRepository<Product,Integer>{
    
         
    //select * from product where price = 500;
    List<Product> findByPrice(double price);
      
    //select * from product where price > 500;
    @Secured("ROLE_SALES")
    @RestResource(path = "pricegreater")
    List<Product> findByPriceGreaterThan(Double price);//http://localhost:8080/users/search/findByPriceGreaterThan?price=500  

    
    //select * from product where price < 500;
    @RolesAllowed("IT")
    @RestResource(path = "priceless") //http://localhost:8080/users/search/Lessthan?price=500  
    List<Product> findByPriceLessThan(Double price); //http://localhost:8080/users/search/findByPriceLessThan?price=500  

    //select * from product where price between 100 and 500;
    @PreAuthorize("hasRole('HR')")
  //  @RestResource(path = "pricebetween")//http://localhost:8080/users/search/pricebetween?price=500  
    List<Product> findByPriceBetween(Double low,Double high);//http://localhost:8080/users/search/findByPriceBetween?low=100&high=500 


}

