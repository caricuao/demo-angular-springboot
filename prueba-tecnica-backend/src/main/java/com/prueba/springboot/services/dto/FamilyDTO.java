/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.springboot.services.dto;

import java.io.Serializable;

/**
 *
 * @author ajrojas
 */
public class FamilyDTO implements Serializable{
    
    private Long id;
    private String name;
    private String lastName;
    private Long idPersona;
    private PersonDTO personDto;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

 @Override
    public String toString() {
        return "PersonaDTO{" +
            "id=" + getId() +
            ", nombre='" + getName()+ "'" +
            ", apellido='" + getLastName() + "'" +
            "}";
    }    

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public PersonDTO getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDTO personDto) {
        this.personDto = personDto;
    }

    
}
