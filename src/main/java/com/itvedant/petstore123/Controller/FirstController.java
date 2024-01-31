package com.itvedant.petstore123.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.petstore123.Entities.RegisteredUser;
import com.itvedant.petstore123.Services.AuthService;

@RestController
public class FirstController {
    

    @Autowired
    private AuthService authService;

    @GetMapping("/register")
    public ResponseEntity<?> registeredUser(@RequestBody RegisteredUser user){

    
      return ResponseEntity.ok(this.authService.register(user));
    }
}

