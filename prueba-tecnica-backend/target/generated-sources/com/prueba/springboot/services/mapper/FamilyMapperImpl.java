package com.prueba.springboot.services.mapper;

import com.prueba.springboot.model.Family;
import com.prueba.springboot.services.dto.FamilyDTO;
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
public class FamilyMapperImpl implements FamilyMapper {

    @Override
    public Family toEntity(FamilyDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Family family = new Family();

        family.setId( dto.getId() );
        family.setName( dto.getName() );
        family.setLastName( dto.getLastName() );

        return family;
    }

    @Override
    public FamilyDTO toDto(Family entity) {
        if ( entity == null ) {
            return null;
        }

        FamilyDTO familyDTO = new FamilyDTO();

        familyDTO.setId( entity.getId() );
        familyDTO.setName( entity.getName() );
        familyDTO.setLastName( entity.getLastName() );

        return familyDTO;
    }

    @Override
    public List<Family> toEntity(List<FamilyDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Family> list = new ArrayList<Family>( dtoList.size() );
        for ( FamilyDTO familyDTO : dtoList ) {
            list.add( toEntity( familyDTO ) );
        }

        return list;
    }

    @Override
    public List<FamilyDTO> toDto(List<Family> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FamilyDTO> list = new ArrayList<FamilyDTO>( entityList.size() );
        for ( Family family : entityList ) {
            list.add( toDto( family ) );
        }

        return list;
    }
}
