package com.carbontec.logiparts.services.impl;

import com.carbontec.logiparts.dto.PartDto;
import com.carbontec.logiparts.jpa.entities.parts.Part;
import com.carbontec.logiparts.jpa.repositories.PartRepository;
import com.carbontec.logiparts.services.PartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PartServiceImpl implements PartService {
    PartRepository partRepository;
    ModelMapper modelMapper;

    @Override
    public List<PartDto> findAll() {
        Iterable<Part> allPart = partRepository.findAll();
        return StreamSupport.stream(allPart.spliterator(), false).
                filter(Part::getIsRoot).
                map(p -> modelMapper.map(p, PartDto.class)).collect(Collectors.toList());
    }
}
