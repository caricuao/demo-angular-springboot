/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.springboot.controller;

import com.prueba.springboot.services.PersonService;
import com.prueba.springboot.services.dto.PersonDTO;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ajrojas
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class PersonController {
    
    @Autowired
    PersonService personService;
    
    @GetMapping("/personas")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<PersonDTO> getAllPerson(){
        return personService.findAllPerson();
    }

    @GetMapping("/persona/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public PersonDTO getPerson(@PathVariable Long id){
        PersonDTO personDTO = personService.finPersonById(id);
        return personDTO;
    }
    
    @PostMapping("/persona/")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO){
        
        if(personDTO.getId()==null){
            if(!personService.isExistPerson(personDTO.getIdentify())){
                PersonDTO to = personService.create(personDTO);
                return ResponseEntity.status(HttpStatus.CREATED).body(to);
            }else{
                return ResponseEntity.status(HttpStatus.CONFLICT).body(personDTO);
            }
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(personDTO);
        }
        
        
    }
    
    @PutMapping("/personas/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody PersonDTO personDTO){
        if(personDTO.getId() > 0){
            PersonDTO to = personService.save(personDTO);
            return ResponseEntity.status(HttpStatus.OK).body(to);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(personDTO);
        }
        
        
    }
    
    
}
