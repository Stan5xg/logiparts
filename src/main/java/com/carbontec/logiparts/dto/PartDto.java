package com.carbontec.logiparts.dto;

import com.carbontec.logiparts.jpa.entities.parts.Part;
import com.carbontec.logiparts.jpa.entities.parts.PartType;
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
