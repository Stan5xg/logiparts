package com.carbontec.logiparts.dto;

import lombok.Data;

import java.util.List;

@Data
public class PartTypeDto {
    private Integer id;
    private List<PartTypeDto> partTypes;
    private List<PartDto> parts;
    private String name;
    private String partNum;
    private Integer parentId;
}
