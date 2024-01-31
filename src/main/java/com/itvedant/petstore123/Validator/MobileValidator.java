package com.itvedant.petstore123.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileValidator implements
 ConstraintValidator<Mobile,String> {

   @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1){

        //return == true is valid   
        //return ==false is invalid
        
        //1 st conditions=>string should be 10 character
        boolean condition1 = arg0.length() == 10;
        
        //2nd condition =>number shoiuld be 0-9
        //string should contains only string
        //+ indicate one or more digits
        boolean condition2 = arg0.matches("[0-9]+");

        boolean result = condition1 && condition2;

        return result;
    }
    
}
