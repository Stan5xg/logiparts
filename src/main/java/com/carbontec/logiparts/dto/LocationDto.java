package com.carbontec.logiparts.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@ToString
public class LocationDto {

    private String name;

    private String postalCode;

    private String address;

    private String formattedAddress;

    @ToString.Exclude
    private Collection<DepartmentDto> departments;

    @ToString.Exclude
    private Collection<CompartmentDto> compartments;
}