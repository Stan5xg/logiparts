package com.carbontec.logiparts.dto;

import com.carbontec.logiparts.jpa.entities.Location;
import lombok.Data;

import java.util.Collection;

@Data
public class DepartmentDto {
    private Integer id;

    private String name;

    private Location location;

    private Collection<UserRegistrationDto> users;
}
