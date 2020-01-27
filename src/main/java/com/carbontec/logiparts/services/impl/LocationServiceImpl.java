package com.carbontec.logiparts.services.impl;

import com.carbontec.logiparts.dto.LocationDto;
import com.carbontec.logiparts.dto.PartDto;
import com.carbontec.logiparts.jpa.entities.Location;
import com.carbontec.logiparts.jpa.entities.Part;
import com.carbontec.logiparts.jpa.repositories.LocationRepository;
import com.carbontec.logiparts.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public Collection<LocationDto> getAllLocations() {
        ModelMapper modelMapper = new ModelMapper();

        Iterable<Location> locations = locationRepository.findAll();
        Stream<Location> locationsStream = StreamSupport.stream(locations.spliterator(), false);
        List<LocationDto> locationDtos = locationsStream.
                map(l -> reinitializeForAll(l, modelMapper)).
                collect(Collectors.toList());
        return locationDtos;
    }

    //work around for LazyInit on Hibernate. Should be replaced with something sensible
    private LocationDto reinitializeForAll(Location location, ModelMapper modelMapper) {
        List<PartDto> partDtos = location.getPart().stream().map(p -> modelMapper.map(p, PartDto.class)).collect(Collectors.toList());
        LocationDto result = modelMapper.map(location, LocationDto.class);
        result.setPartDtos(partDtos);

        return  result;
    }
}
