package com.carbontec.logiparts.services.impl;

import com.carbontec.logiparts.dto.CompartmentDto;
import com.carbontec.logiparts.jpa.entities.Compartment;
import com.carbontec.logiparts.jpa.entities.Location;
import com.carbontec.logiparts.jpa.repositories.CompartmentRepository;
import com.carbontec.logiparts.services.CompartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class CompartmentServiceImpl implements CompartmentService {
    private final CompartmentRepository compartmentRepository;

    @Override
    public Collection<CompartmentDto> getCompartmentsByLocation(Location location) {
        Iterable<Compartment> compartments = compartmentRepository.findCompartmentByLocation(location);
        Stream<Compartment> compartmentStream = StreamSupport.stream(compartments.spliterator(), false);
        return compartmentStream.map(c -> {
            CompartmentDto compartmentDto = new CompartmentDto();
            compartmentDto.setName(c.getName());
            return compartmentDto;
        }).collect(Collectors.toList());
    }
}
