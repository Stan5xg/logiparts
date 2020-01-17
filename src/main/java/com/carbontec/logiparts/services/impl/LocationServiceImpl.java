package com.carbontec.logiparts.services.impl;

import com.carbontec.logiparts.dto.LocationDto;
import com.carbontec.logiparts.jpa.entities.Location;
import com.carbontec.logiparts.jpa.repositories.LocationRepository;
import com.carbontec.logiparts.services.CompartmentService;
import com.carbontec.logiparts.services.DepartmentService;
import com.carbontec.logiparts.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private static final String SEPARATOR = " ";

    private final LocationRepository locationRepository;
    private final DepartmentService departmentService;
    private final CompartmentService compartmentService;

    @Override
    public Collection<LocationDto> getAllLocations() {

        Iterable<Location> locations = locationRepository.findAll();
        Stream<Location> locationsStream = StreamSupport.stream(locations.spliterator(), false);
        List<LocationDto> locationDtos = locationsStream.map(l -> {
            LocationDto locationDto = new LocationDto();
            locationDto.setName(l.getName());
            locationDto.setFormattedAddress(getFormattedAdress(l.getPostalCode(), l.getAddress()));
            locationDto.setDepartments(departmentService.getDepartmentsForLocation(l));
            locationDto.setCompartments(compartmentService.getCompartmentsByLocation(l));
            return locationDto;
        }).collect(Collectors.toList());

        return locationDtos;
    }

    private String getFormattedAdress(String postalCode, String address) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(postalCode);
        stringBuffer.append(SEPARATOR);
        stringBuffer.append(address);

        return stringBuffer.toString();
    }
}
