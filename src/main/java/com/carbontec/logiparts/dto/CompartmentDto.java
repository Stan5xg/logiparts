package com.carbontec.logiparts.dto;

import com.carbontec.logiparts.jpa.entities.Location;
import lombok.Data;

@Data
public class CompartmentDto {
    private Integer id;

    private String name;

    private Location location;
}
