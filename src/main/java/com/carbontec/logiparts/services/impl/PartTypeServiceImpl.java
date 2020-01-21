package com.carbontec.logiparts.services.impl;

import com.carbontec.logiparts.dto.PartTypeDto;
import com.carbontec.logiparts.jpa.entities.parts.PartType;
import com.carbontec.logiparts.jpa.repositories.PartTypeRepository;
import com.carbontec.logiparts.services.PartTypeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ListUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class PartTypeServiceImpl implements PartTypeService {
    public static final String MESSAGE_NOT_FOUTD = "Couldn't find part type with ID";
    private final PartTypeRepository partTypeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PartTypeDto> findAll() {
        Iterable<PartType> allPartTypes = partTypeRepository.findAll();
        return StreamSupport.stream(allPartTypes.spliterator(), false).
                filter(PartType::getIsRoot).
                map(p -> modelMapper.map(p, PartTypeDto.class)).collect(Collectors.toList());
    }

    @Override
    public void add(PartTypeDto partTypeDto) {
        PartType partType = modelMapper.map(partTypeDto, PartType.class);
        PartType savedPartType = partTypeRepository.save(partType);

        Integer parentId = partTypeDto.getParentId();
        if (null == parentId) {
            return;
        }

        PartType parent = getPartType(parentId);
        parent.getPartTypes().add(savedPartType);
        partTypeRepository.save(parent);
    }

    @Override
    public void remove(Integer id) {
        if (null == id) {
            return;
        }

        PartType partType = getPartType(id);
        partTypeRepository.delete(partType);
    }

    private PartType getPartType(Integer id) {
        Optional<PartType> partTypeOptional = partTypeRepository.findById(id);
        if (!partTypeOptional.isPresent()) {
            throw  new RuntimeException(MESSAGE_NOT_FOUTD);
        }
        return partTypeOptional.get();
    }


}
