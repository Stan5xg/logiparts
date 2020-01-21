package com.carbontec.logiparts.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class ParameterDto {
    private Integer id;
    private String name;
    private List<ParameterValueDto> parameterValue;
}
