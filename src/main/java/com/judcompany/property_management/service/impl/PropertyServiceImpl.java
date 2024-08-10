package com.judcompany.property_management.service.impl;

import com.judcompany.property_management.converter.PropertyConverter;
import com.judcompany.property_management.dto.PropertyDTO;
import com.judcompany.property_management.entity.PropertyEntity;
import com.judcompany.property_management.repository.PropertyRepository;
import com.judcompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe = propertyConverter.convertDtoTooEntity(propertyDTO);
        pe = propertyRepository.save(pe);
        propertyDTO = propertyConverter.convertEntityToDto(pe);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> propertyList = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        for (PropertyEntity pe : propertyList) {
            PropertyDTO dto = propertyConverter.convertEntityToDto(pe);
            propertyDTOList.add(dto);
        }
        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if (optEnt.isPresent()) {
            PropertyEntity entity = optEnt.get(); //data from database
            entity.setTitle(propertyDTO.getTitle());
            entity.setDescription(propertyDTO.getDescription());
            entity.setOwnerName(propertyDTO.getOwnerName());
            entity.setOwnerEmail(propertyDTO.getOwnerEmail());
            entity.setPrice(propertyDTO.getPrice());
            entity.setAddress(propertyDTO.getAddress());
            dto = propertyConverter.convertEntityToDto(entity);
            propertyRepository.save(entity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if (optEnt.isPresent()) {
            PropertyEntity entity = optEnt.get(); //data from database
            entity.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntityToDto(entity);
            propertyRepository.save(entity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if (optEnt.isPresent()) {
            PropertyEntity entity = optEnt.get(); //data from database
            entity.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntityToDto(entity);
            propertyRepository.save(entity);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
