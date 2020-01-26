package com.carbontec.logiparts.services.impl;

import com.carbontec.logiparts.dto.PartDto;
import com.carbontec.logiparts.jpa.entities.Part;
import com.carbontec.logiparts.jpa.entities.PartType;
import com.carbontec.logiparts.jpa.repositories.PartRepository;
import com.carbontec.logiparts.services.PartService;
import com.carbontec.logiparts.services.PartTypeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PartServiceImpl implements PartService {
    private static final String MESSAGE_NOT_FOUTD = "Can't find part";
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final PartTypeService partTypeService;

    @Override
    public List<PartDto> findAll() {
        Iterable<Part> allPart = partRepository.findAll();
        return StreamSupport.stream(allPart.spliterator(), false).
                filter(Part::getIsRoot).
                map(p -> modelMapper.map(p, PartDto.class)).collect(Collectors.toList());
    }

    @Override
    public void save(PartDto partDto) {
        Part part = modelMapper.map(partDto, Part.class);
        Integer partTypeId = partDto.getPartTypeId();
        if (null != partTypeId) {
            PartType partType = partTypeService.getPartType(partTypeId);
            part.setPartType(partType);
        }
        Part savedPart = partRepository.save(part);
        Integer parentId = partDto.getParentId();

        if (null != parentId) {
            Part parentPart = getPart(parentId);
            parentPart.getParts().add(savedPart);
            partRepository.save(parentPart);
        }
    }

    private Part getPart(Integer id) {
        Optional<Part> partOptional = partRepository.findById(id);
        if (!partOptional.isPresent()) {
            throw  new RuntimeException(MESSAGE_NOT_FOUTD);
        }
        return partOptional.get();
    }
}
