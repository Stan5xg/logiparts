package com.carbontec.logiparts.jpa.repositories;

import com.carbontec.logiparts.jpa.entities.Location;
import com.carbontec.logiparts.jpa.entities.parts.Part;
import org.springframework.data.repository.CrudRepository;

public interface PartRepository extends CrudRepository<Part, Integer> {
}
