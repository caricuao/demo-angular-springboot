/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.springboot.services.impl;

import com.prueba.springboot.model.Relationship;
import com.prueba.springboot.repository.RelationShipRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ajrojas
 */
@Service
public class RelationshipImpl {
    
    @Autowired
    RelationShipRepository relationShipRepository;
    
    public List<Relationship> findAll(){
        return relationShipRepository.findAll();
    }
    
    
}
