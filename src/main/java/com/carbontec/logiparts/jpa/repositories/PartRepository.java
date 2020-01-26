package com.carbontec.logiparts.jpa.repositories;

import com.carbontec.logiparts.jpa.entities.Part;
import org.springframework.data.repository.CrudRepository;

public interface PartRepository extends CrudRepository<Part, Integer> {
}
