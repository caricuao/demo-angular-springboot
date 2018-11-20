/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.springboot.repository;

import com.prueba.springboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ajrojas
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    
    public Person findByIdentify(String identify);
    
}
