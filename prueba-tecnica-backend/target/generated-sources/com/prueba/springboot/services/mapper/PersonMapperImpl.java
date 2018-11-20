package com.prueba.springboot.services.mapper;

import com.prueba.springboot.model.Family;
import com.prueba.springboot.model.Person;
import com.prueba.springboot.services.dto.FamilyDTO;
import com.prueba.springboot.services.dto.PersonDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-19T19:54:27-0400",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toEntity(PersonDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( dto.getId() );
        person.setName( dto.getName() );
        person.setLastName( dto.getLastName() );
        person.setGender( dto.getGender() );
        person.setDateOfBirth( dto.getDateOfBirth() );
        person.setEmail( dto.getEmail() );
        person.setIdentify( dto.getIdentify() );
        person.setAddress( dto.getAddress() );
        person.setListFamily( familyDTOArrayListToFamilyList( dto.getListFamily() ) );

        return person;
    }

    @Override
    public PersonDTO toDto(Person entity) {
        if ( entity == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( entity.getId() );
        personDTO.setName( entity.getName() );
        personDTO.setLastName( entity.getLastName() );
        personDTO.setGender( entity.getGender() );
        personDTO.setDateOfBirth( entity.getDateOfBirth() );
        personDTO.setEmail( entity.getEmail() );
        personDTO.setIdentify( entity.getIdentify() );
        personDTO.setAddress( entity.getAddress() );
        personDTO.setListFamily( familyListToFamilyDTOArrayList( entity.getListFamily() ) );

        return personDTO;
    }

    @Override
    public List<Person> toEntity(List<PersonDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Person> list = new ArrayList<Person>( dtoList.size() );
        for ( PersonDTO personDTO : dtoList ) {
            list.add( toEntity( personDTO ) );
        }

        return list;
    }

    @Override
    public List<PersonDTO> toDto(List<Person> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PersonDTO> list = new ArrayList<PersonDTO>( entityList.size() );
        for ( Person person : entityList ) {
            list.add( toDto( person ) );
        }

        return list;
    }

    protected Family familyDTOToFamily(FamilyDTO familyDTO) {
        if ( familyDTO == null ) {
            return null;
        }

        Family family = new Family();

        family.setId( familyDTO.getId() );
        family.setName( familyDTO.getName() );
        family.setLastName( familyDTO.getLastName() );

        return family;
    }

    protected List<Family> familyDTOArrayListToFamilyList(ArrayList<FamilyDTO> arrayList) {
        if ( arrayList == null ) {
            return null;
        }

        List<Family> list = new ArrayList<Family>( arrayList.size() );
        for ( FamilyDTO familyDTO : arrayList ) {
            list.add( familyDTOToFamily( familyDTO ) );
        }

        return list;
    }

    protected FamilyDTO familyToFamilyDTO(Family family) {
        if ( family == null ) {
            return null;
        }

        FamilyDTO familyDTO = new FamilyDTO();

        familyDTO.setId( family.getId() );
        familyDTO.setName( family.getName() );
        familyDTO.setLastName( family.getLastName() );

        return familyDTO;
    }

    protected ArrayList<FamilyDTO> familyListToFamilyDTOArrayList(List<Family> list) {
        if ( list == null ) {
            return null;
        }

        ArrayList<FamilyDTO> arrayList = new ArrayList<FamilyDTO>();
        for ( Family family : list ) {
            arrayList.add( familyToFamilyDTO( family ) );
        }

        return arrayList;
    }
}
