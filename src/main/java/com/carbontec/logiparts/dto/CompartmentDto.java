package com.carbontec.logiparts.dto;

import lombok.Data;

@Data
public class CompartmentDto {
    private Integer id;

    private String name;

    private LocationDto location;
}
