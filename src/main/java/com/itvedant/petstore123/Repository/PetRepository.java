package com.itvedant.petstore123.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.petstore123.Entities.Pet;

@Repository
public interface PetRepository extends
JpaRepository<Pet,Integer> {

    
}
    

