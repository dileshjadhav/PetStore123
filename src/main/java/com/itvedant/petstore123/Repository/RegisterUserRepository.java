package com.itvedant.petstore123.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.itvedant.petstore123.Entities.RegisteredUser;
import com.itvedant.petstore123.Entities.User;

public interface RegisterUserRepository
extends JpaRepository <RegisteredUser,Integer> {

    //disallow the direct call to the save method means the post request is disabled 
       @RestResource(exported = false)
       <S extends RegisteredUser> S save(S entity);
          
       RegisteredUser findByEmail(String email);
      }

   

    

