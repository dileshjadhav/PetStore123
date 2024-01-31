package com.itvedant.petstore123.Validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Payload;

import jakarta.validation.Constraint;

@Constraint(validatedBy = MobileValidator.class)
@Target(ElementType.FIELD) //only perticular filed not to class want to applied.
@Retention(RetentionPolicy.RUNTIME) //runtime annotation will do
public @interface Mobile{
    
      
    String message() default "Invalid mobile number";

    Class<?> [] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}

