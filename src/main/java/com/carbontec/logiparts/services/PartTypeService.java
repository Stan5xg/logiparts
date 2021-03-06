package com.carbontec.logiparts.services;

import com.carbontec.logiparts.dto.PartTypeDto;
import com.carbontec.logiparts.jpa.entities.PartType;

import java.util.List;

public interface PartTypeService {
    List<PartTypeDto> findAll();

    void add(PartTypeDto partTypeDto);

    void remove(Integer id);

    PartType getPartType(Integer id);
}
