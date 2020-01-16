package com.carbontec.logiparts.jpa.repositories;

import com.carbontec.logiparts.jpa.entities.Department;
import com.carbontec.logiparts.jpa.entities.Location;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
