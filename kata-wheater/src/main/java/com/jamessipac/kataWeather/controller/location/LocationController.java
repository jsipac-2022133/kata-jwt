package com.jamessipac.kataWeather.controller.location;

import com.jamessipac.kataWeather.dto.LocationResponseDto;
import com.jamessipac.kataWeather.model.Location;
import com.jamessipac.kataWeather.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> findAll(){
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResponseDto> getLocationById(@PathVariable String id) {
        try {
            LocationResponseDto locationDto = locationService.getLocationById(id);
            return ResponseEntity.ok(locationDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location) {
        try {
            // Intentar guardar la location
            Location nuevaLocation = locationService.save(location);
            return ResponseEntity.ok(nuevaLocation);
        } catch (IllegalArgumentException e) {
            // Si el usuario no existe, devolver un 400 Bad Request con el mensaje de error
            return ResponseEntity.badRequest().body(null);
        }
    }


    @PutMapping("/{idLocation}")
    public ResponseEntity<Location> update(@PathVariable String idLocation, @RequestBody Location location){
        try {
            Location actualizarLocation =locationService.update(idLocation, location);
            return ResponseEntity.ok(actualizarLocation);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(null);
        }

    }

    @DeleteMapping("{idLocation}")
    public void deleteById(@PathVariable String idLocation){
        locationService.deleteById(idLocation);
    }
}
