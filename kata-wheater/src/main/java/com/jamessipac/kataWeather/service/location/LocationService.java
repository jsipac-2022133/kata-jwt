package com.jamessipac.kataWeather.service.location;

import com.jamessipac.kataWeather.dto.LocationResponseDto;
import com.jamessipac.kataWeather.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> findAll();
    Location findById(String id);
    Location save(Location location);
    Location update(String id, Location location);
    void deleteById(String id);
    LocationResponseDto getLocationById(String locationId);
}
