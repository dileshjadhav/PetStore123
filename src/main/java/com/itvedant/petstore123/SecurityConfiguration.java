package com.itvedant.petstore123;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.itvedant.petstore123.Services.AuthUserService;

@EnableWebSecurity
@Configuration 
@EnableMethodSecurity(
    prePostEnabled = true,
    jsr250Enabled = true,
    securedEnabled = true
)
public class SecurityConfiguration {
   @Bean
    public SecurityFilterChain Configure(HttpSecurity http)
    throws Exception{
        http.csrf().disable()     //allow    POST,DELETE,PUT
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.GET, "/products/**").permitAll() //** can access all id{}}
            .requestMatchers(HttpMethod.POST, "/products/**").permitAll() 
            //.requestMatchers(HttpMethod.POST,"/registeruser").permitAll()
            .requestMatchers(HttpMethod.POST,"/register").permitAll()
            .requestMatchers("/users/**").hasRole("HR")
            .requestMatchers("/categories/**").hasAnyRole("IT","SALES")
            .anyRequest().authenticated()
            .and()
            .httpBasic()
            .and()
            .authenticationProvider(daoAuthenticationProvider());

        return http.build();
    }
     
    @Autowired
    private AuthUserService authUserService;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.authUserService);
        provider.setPasswordEncoder(this.passwordEncoder());
        return provider;
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsService users() {
        //while creating user we need
        //1.username
        //2.password
        //3.role
        UserDetails user1 =  org.springframework.security.core.userdetails.User.builder()
                                   .username("harry")
                                   .password(passwordEncoder().encode("abc@123"))
                                   .roles("HR")
                                   .build();

        UserDetails user2 =  org.springframework.security.core.userdetails.User.builder()
                                    .username("MIKE")
                                    .password(passwordEncoder().encode("xyz@123"))
                                    .roles("IT")
                                    .build();
                                    

        UserDetails user3 = org.springframework.security.core.userdetails.User.builder()
                                    .username("JOHN")
                                    .password(passwordEncoder().encode("mno@123"))
                                    .roles("HR","SALES")
                                    .build();
                                                               
        return new InMemoryUserDetailsManager(user1, user2, user3);
         
    }

    }


