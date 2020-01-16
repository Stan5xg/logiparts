package com.carbontec.logiparts.services.impl;

import com.carbontec.logiparts.dto.LocationDto;
import com.carbontec.logiparts.jpa.entities.Location;
import com.carbontec.logiparts.jpa.repositories.LocationRepository;
import com.carbontec.logiparts.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Collection<LocationDto> getAllLocations() {

        Iterable<Location> locations = locationRepository.findAll();
        Stream<Location> locationsStream = StreamSupport.stream(locations.spliterator(), false);
        List<LocationDto> locationDtos = locationsStream.map(l -> {
            LocationDto locationDto = new LocationDto();
            locationDto.setAddress(l.getAddress());
            locationDto.setName(l.getName());
            locationDto.setPostalCode(l.getPostalCode());
            return locationDto;
        }).collect(Collectors.toList());

        return locationDtos;
    }
}
