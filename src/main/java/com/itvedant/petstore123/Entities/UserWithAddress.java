package com.itvedant.petstore123.Entities;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "userwithaddress", types = {User.class})
public interface UserWithAddress {

    
    @Value("#{target.firstname + ' ' + target.lastname}")
    String getname();
     
     @Value("#{target.useraddress.city}")
    String getCity();
    
    @Value("#{target.useraddress.state}")
    String getState();
    
    @Value("#{target.useraddress.country}")
     String getcountry();
    
}
    


    
    


