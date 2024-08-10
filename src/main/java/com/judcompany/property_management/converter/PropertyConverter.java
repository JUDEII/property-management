package com.judcompany.property_management.converter;

import com.judcompany.property_management.dto.PropertyDTO;
import com.judcompany.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDtoTooEntity(PropertyDTO propertyDTO) {
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setPrice(propertyDTO.getPrice());
        pe.setAddress(propertyDTO.getAddress());

        return pe;
    }

    public PropertyDTO convertEntityToDto(PropertyEntity propertyEntity) {
        PropertyDTO dto = new PropertyDTO();
        dto.setId(propertyEntity.getId());
        dto.setTitle(propertyEntity.getTitle());
        dto.setDescription(propertyEntity.getDescription());
        dto.setOwnerName(propertyEntity.getOwnerName());
        dto.setOwnerEmail(propertyEntity.getOwnerEmail());
        dto.setPrice(propertyEntity.getPrice());
        dto.setAddress(propertyEntity.getAddress());

        return dto;
    }
}
