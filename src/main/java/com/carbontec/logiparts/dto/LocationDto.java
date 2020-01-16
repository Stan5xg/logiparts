package com.carbontec.logiparts.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
public class LocationDto {
    @NotNull
    @NotEmpty
    private String address;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String postalCode;

    private Collection<DepartmentDto> departments;

    private Collection<CompartmentDto> compartment;
}
