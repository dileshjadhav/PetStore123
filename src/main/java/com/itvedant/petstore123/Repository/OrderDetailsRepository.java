package com.itvedant.petstore123.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.itvedant.petstore123.Entities.OrderDetails;
@RestResource(path = "orderdetails")
public interface  OrderDetailsRepository 
extends JpaRepository<OrderDetails,Integer> {

    
}
