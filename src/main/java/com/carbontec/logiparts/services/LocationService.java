package com.carbontec.logiparts.services;

import com.carbontec.logiparts.dto.LocationDto;

import java.util.Collection;

public interface LocationService {
    Collection<LocationDto> getAllLocations();
}
