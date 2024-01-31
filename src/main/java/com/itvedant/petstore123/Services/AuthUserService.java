package com.itvedant.petstore123.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itvedant.petstore123.Entities.RegisteredUser;
import com.itvedant.petstore123.Repository.RegisterUserRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthUserService implements UserDetailsService {

       
    @Autowired
    private RegisterUserRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) 
                                                   throws UsernameNotFoundException {
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");

        RegisteredUser foundUser =  this.repository.findByEmail(username);
        if (foundUser == null) {
            throw new UsernameNotFoundException("User with this ID does not exists");
            
        }
        else{
            java.util.Collection<GrantedAuthority> authorities =new ArrayList<>();

            for(String role: foundUser.getRoles()){
                authorities.add(new SimpleGrantedAuthority(role));
            }

            RegisteredUser user = new RegisteredUser(foundUser.getEmail(),foundUser.getPassword(), authorities);

             return user;
        }



    } 
    
}
