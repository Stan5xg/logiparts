package com.carbontec.logiparts.dto;

import lombok.Data;

import java.util.List;

@Data
public class PartDto {
    private Integer id;
    private PartTypeDto partType;
    private Integer partTypeId;
    private List<ParameterValueDto> parameterValues;
    private List<PartDto> parts;
    private String serialNum;
    private LocationDto location;
    private Boolean isRoot;
    private Integer parentId;
}
