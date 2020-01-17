package com.carbontec.logiparts.jpa.repositories;

import com.carbontec.logiparts.jpa.entities.Compartment;
import com.carbontec.logiparts.jpa.entities.Location;
import org.springframework.data.repository.CrudRepository;

public interface CompartmentRepository extends CrudRepository<Compartment, Integer> {
    Iterable<Compartment> findCompartmentByLocation(Location location);
}
