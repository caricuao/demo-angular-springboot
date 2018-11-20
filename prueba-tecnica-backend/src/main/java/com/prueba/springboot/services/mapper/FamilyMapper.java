/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.springboot.services.mapper;

import com.prueba.springboot.model.Family;
import com.prueba.springboot.services.dto.FamilyDTO;
import org.mapstruct.Mapper;

/**
 *
 * @author ajrojas
 */
@Mapper(componentModel = "spring", uses = {})
public interface FamilyMapper extends EntityMapper<FamilyDTO,Family>{
    
}
