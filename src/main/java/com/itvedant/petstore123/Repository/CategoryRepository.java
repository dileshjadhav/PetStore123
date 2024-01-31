package com.itvedant.petstore123.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.itvedant.petstore123.Entities.Category;
@RestResource(path = "OrderDetails")
public interface CategoryRepository extends
JpaRepository<Category,Integer> {
    
    
} 

