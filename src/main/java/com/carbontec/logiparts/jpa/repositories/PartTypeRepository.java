package com.carbontec.logiparts.jpa.repositories;

import com.carbontec.logiparts.jpa.entities.Location;
import com.carbontec.logiparts.jpa.entities.parts.Part;
import com.carbontec.logiparts.jpa.entities.parts.PartType;
import org.springframework.data.repository.CrudRepository;

public interface PartTypeRepository extends CrudRepository<PartType, Integer> {

}