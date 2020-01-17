package com.carbontec.logiparts.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
public class LocationDto {

    private String name;

    private String postalCode;

    private String address;

    private String formattedAddress;

    private Collection<DepartmentDto> departments;

    private Collection<CompartmentDto> compartment;
}
