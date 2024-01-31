package com.itvedant.petstore123.Repository;

import java.util.List;

//import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.itvedant.petstore123.Entities.UserWithoutPassword;
       
       @RepositoryRestResource(excerptProjection = UserWithoutPassword.class)
       public interface UserRepository extends
         JpaRepository <com.itvedant.petstore123.Entities.User,Integer>{

    
        //contains predefined userdefined query methods
        //query methos are methods that are just declare in the interface
        //when we call  these methods ,the hibernate will responds to this call
        //by creating the sql queries that will be given to the database for execution
        //save=>insert/update
        //find=>select=>read
        //delete=>delete
    
        List<com.itvedant.petstore123.Entities.User> findByFirstName(String firstName);
        //select * from user where  email=?
         com.itvedant.petstore123.Entities.User findByEmail(String email);
   
         //select * from user where email like '%e'
         List<com.itvedant.petstore123.Entities.User> findByEmailContaining(String pattern);//http://localhost:8080/users/search/findByEmailContaining?pattern=u or h or any character starts with alphabet
       
    
} 
    

