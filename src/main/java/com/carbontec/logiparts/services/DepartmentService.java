package com.carbontec.logiparts.services;

import com.carbontec.logiparts.dto.DepartmentDto;
import com.carbontec.logiparts.jpa.entities.Location;

import java.util.Collection;

public interface DepartmentService {
    Collection<DepartmentDto> getDepartmentsForLocation(Location location);
}
