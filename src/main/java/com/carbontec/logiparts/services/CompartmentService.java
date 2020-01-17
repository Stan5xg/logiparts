package com.carbontec.logiparts.services;

import com.carbontec.logiparts.dto.CompartmentDto;
import com.carbontec.logiparts.jpa.entities.Location;

import java.util.Collection;

public interface CompartmentService {
    Collection<CompartmentDto> getCompartmentsByLocation(Location location);
}
