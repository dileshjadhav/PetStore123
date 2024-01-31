package com.itvedant.petstore123.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.petstore123.Entities.Address;

public interface AddressRepository 
extends JpaRepository<Address,Integer>{     
    

    
    //extends PagingAndSortingRepository<Address,Integer> { this only perform Crud and paging and sorting
    //CRUD means Read only. not create, update,delete
    //combination of crud and paging and sorting.
            
    }

