package com.judcompany.property_management.repository;

import com.judcompany.property_management.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {

}
