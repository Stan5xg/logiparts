package com.carbontec.logiparts.jpa.repositories;

import com.carbontec.logiparts.jpa.entities.Location;
import org.springframework.data.repository.CrudRepository;


public interface LocationRepository extends CrudRepository<Location, Integer> {
}
