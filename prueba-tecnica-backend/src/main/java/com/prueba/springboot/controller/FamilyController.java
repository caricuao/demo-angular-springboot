/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.springboot.controller;

import com.prueba.springboot.services.FamilyService;
import com.prueba.springboot.services.dto.FamilyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
public class FamilyController {
    
    @Autowired
    FamilyService familyService;
    
    @PostMapping("/familia/")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<FamilyDTO> createFamily(@RequestBody FamilyDTO familyDTO){
        System.out.println("FamilyController "+familyDTO.getPersonDto());
        if(familyDTO.getId()==null){
            //if(!personService.isExistPerson(personDTO.getIdentify())){
                FamilyDTO to = familyService.save(familyDTO);
                return ResponseEntity.status(HttpStatus.CREATED).body(to);
            //}else{
            //    return ResponseEntity.status(HttpStatus.CONFLICT).body(personDTO);
            //}
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(familyDTO);
        }
        
        
    }
}
