package com.carbontec.logiparts.dto;

import lombok.Data;

import java.util.List;

@Data
public class PartTypeDto {
    private Integer id;
    private List<PartTypeDto> partTypes;
    private String name;
    private String partNum;
    private Integer parentId;
}
