package com.carbontec.logiparts.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class ParameterValueDto {
    private Integer id;
    private ParameterDto parameter;
    private String value;
}
