/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.springboot.repository;

import com.prueba.springboot.model.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ajrojas
 */
@Repository
public interface RelationShipRepository extends JpaRepository<Relationship, Long>{
    
}
