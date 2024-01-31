package com.itvedant.petstore123.Entities;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "userswithoutpassword",types = {User.class})
public interface UserWithoutPassword { //interface means only getter method

    //closed projection
    //the name of the field that to be  
    // @Value("#{target.firstName}")
    // String getFName();
    // @Value("#{target.lastName}")
    // String getLName();
   
    // String getEmail();
    @Value("#{target.firstName +' ' + target.lastname}") 
    String getName();
}

