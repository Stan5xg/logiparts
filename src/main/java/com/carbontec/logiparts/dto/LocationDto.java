package com.carbontec.logiparts.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
}
