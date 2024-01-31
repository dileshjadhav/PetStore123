package com.itvedant.petstore123.Services;

//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itvedant.petstore123.Entities.RegisteredUser;
import com.itvedant.petstore123.Repository.RegisterUserRepository;
@Service
public class AuthService {
    
    @Autowired
    private RegisterUserRepository repository;

     @Autowired
     private BCryptPasswordEncoder passwordEncoder;

    public String register(RegisteredUser user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         this.repository.save(user);
         return "User register sucessfully";
        

    }
}
