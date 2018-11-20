/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.springboot.services.mapper;

import com.prueba.springboot.model.Person;
import com.prueba.springboot.services.dto.PersonDTO;
import org.mapstruct.*;

/**
 *
 * @author ajrojas
 */
@Mapper(componentModel = "spring", uses = {})
public interface PersonMapper extends EntityMapper<PersonDTO, Person>{
    
}
