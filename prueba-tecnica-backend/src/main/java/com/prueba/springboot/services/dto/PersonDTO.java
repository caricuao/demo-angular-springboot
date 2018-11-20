/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.springboot.services.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ajrojas
 */
public class PersonDTO implements Serializable{

    private static final long serialVersionUID = -3860826555548882026L;
    
    private Long id;
    private String name;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String email;
    private String identify;
    private String address;
    private ArrayList<FamilyDTO> listFamily;

    
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PersonDTO dto = (PersonDTO) o;
        if(dto.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PersonaDTO{" +
            "id=" + getId() +
            ", nombre='" + getName()+ "'" +
            ", apellido='" + getLastName() + "'" +
            ", email='" + getEmail()+ "'" +   
            ", direccion='" + getAddress()+ "'" +    
            "}";
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<FamilyDTO> getListFamily() {
        return listFamily;
    }

    public void setListFamily(ArrayList<FamilyDTO> listFamily) {
        this.listFamily = listFamily;
    }

    
}
