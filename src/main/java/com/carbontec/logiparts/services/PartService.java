package com.carbontec.logiparts.services;

import com.carbontec.logiparts.dto.PartDto;

import java.util.List;

public interface PartService {
    List<PartDto> findAll();
}
