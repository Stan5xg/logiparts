package com.carbontec.logiparts.dto;

import com.carbontec.logiparts.jpa.entities.parts.PartType;
import lombok.Data;

import java.util.List;

@Data
public class PartDto {
    private Integer id;
    private PartType partType;
    private List<ParameterValueDto> parameterValues;
    private String serialNum;
    private LocationDto location;
    private Boolean isRoot;
}
