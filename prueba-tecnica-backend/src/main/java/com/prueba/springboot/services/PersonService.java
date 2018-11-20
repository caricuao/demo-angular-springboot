/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.springboot.services;

import com.prueba.springboot.services.dto.PersonDTO;
import java.util.List;

/**
 *
 * @author ajrojas
 */
public interface PersonService {
    
    List<PersonDTO> findAllPerson();
    PersonDTO finPersonById(Long id);
    PersonDTO save(PersonDTO dto);
    boolean isExistPerson(String identify);
    PersonDTO create(PersonDTO dto);
}
