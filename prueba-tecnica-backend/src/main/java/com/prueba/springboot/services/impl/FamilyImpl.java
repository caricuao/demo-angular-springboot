/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.springboot.services.impl;

import com.prueba.springboot.model.Family;
import com.prueba.springboot.model.Person;
import com.prueba.springboot.repository.FamilyRepository;
import com.prueba.springboot.services.FamilyService;
import com.prueba.springboot.services.dto.FamilyDTO;
import com.prueba.springboot.services.mapper.FamilyMapper;
import com.prueba.springboot.services.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ajrojas
 */
@Service
public class FamilyImpl implements FamilyService{
    
    @Autowired
    FamilyRepository familyRepository;
    
    @Autowired
    FamilyMapper familyMapper;
    
    @Autowired
    PersonMapper peronMapper;
    
    @Override
    public FamilyDTO save(FamilyDTO dto){
        /*Person person = new Person();
        person.setId(dto.getIdPersona());
        Family family = new Family();
        family.setLastName(dto.getLastName());
        family.setName(dto.getName());
        family.setPerson(person);
        family = familyRepository.save(familyMapper.toEntity(dto));*/
        System.out.println("FamilyImpl save "+dto.getPersonDto());
        
        Family family = familyMapper.toEntity(dto);
        family.setPerson(peronMapper.toEntity(dto.getPersonDto()));
        familyRepository.save(family);
        return familyMapper.toDto(family);
    }
    
    
}
