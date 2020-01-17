package com.carbontec.logiparts.services.impl;

import com.carbontec.logiparts.dto.DepartmentDto;
import com.carbontec.logiparts.jpa.entities.Department;
import com.carbontec.logiparts.jpa.entities.Location;
import com.carbontec.logiparts.jpa.repositories.DepartmentRepository;
import com.carbontec.logiparts.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Collection<DepartmentDto> getDepartmentsForLocation(Location location) {
        Iterable<Department> departments = departmentRepository.findDepartmentByLocation(location);
        Stream<Department> departmentsStream = StreamSupport.stream(departments.spliterator(), false);
        return departmentsStream.map(d -> {
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setName(d.getName());
            return departmentDto;
        }).collect(Collectors.toList());
    }
}
