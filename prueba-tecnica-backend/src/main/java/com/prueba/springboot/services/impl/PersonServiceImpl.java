/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.springboot.services.impl;

import com.prueba.springboot.model.Person;
import com.prueba.springboot.repository.PersonRepository;
import com.prueba.springboot.services.PersonService;
import com.prueba.springboot.services.dto.PersonDTO;
import com.prueba.springboot.services.mapper.PersonMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ajrojas
 */
@Service
public class PersonServiceImpl implements PersonService{
    
    @Autowired
    PersonRepository personRepository;
    
    @Autowired
    PersonMapper personMapper;
    

    @Override
    public List<PersonDTO> findAllPerson(){
        List<Person> listPerson = personRepository.findAll();
        List<PersonDTO> listPersonDTO = new ArrayList<>();
        PersonDTO dto = null;
        for(Person person : listPerson){
            dto = new PersonDTO();
            dto.setAddress(person.getAddress());
            dto.setEmail(person.getEmail());
            dto.setGender(person.getGender());
            dto.setId(person.getId());
            dto.setIdentify(person.getIdentify());
            dto.setLastName(person.getLastName());
            dto.setName(person.getName());
            listPersonDTO.add(dto);
        }
        
        return listPersonDTO;
    }
    
    @Override
    public PersonDTO finPersonById(Long id){
        return personMapper.toDto(personRepository.findOne(id));
    }
    
    @Override
    public PersonDTO save(PersonDTO dto){
        Person personToUpdate = personRepository.getOne(dto.getId());
        personToUpdate.setAddress(dto.getAddress());
        personToUpdate.setEmail(dto.getEmail());
        personToUpdate.setGender(dto.getGender());
        personToUpdate.setIdentify(dto.getIdentify());
        personToUpdate.setLastName(dto.getLastName());
        personToUpdate.setName(dto.getName());
        personRepository.save(personToUpdate);
        return personMapper.toDto(personToUpdate);
    }
    
    @Override
    public boolean isExistPerson(String identify){
        return personRepository.findByIdentify(identify)!=null;
    }
    
    @Override
    public PersonDTO create(PersonDTO dto){
        Person person = personRepository.save(personMapper.toEntity(dto));
        return personMapper.toDto(person);
    }
    
}
