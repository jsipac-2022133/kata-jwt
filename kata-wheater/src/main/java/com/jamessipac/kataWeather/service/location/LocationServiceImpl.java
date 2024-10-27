package com.jamessipac.kataWeather.service.location;

import com.jamessipac.kataWeather.dto.LocationResponseDto;
import com.jamessipac.kataWeather.model.Location;
import com.jamessipac.kataWeather.model.Usuario;
import com.jamessipac.kataWeather.repository.location.LocationRepository;
import com.jamessipac.kataWeather.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Location> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Location findById(String id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public Location save(Location location) {


        Optional<Usuario> usuario = usuarioRepository.findById(location.getUsuarioId());
        if (usuario.isPresent()) {
            // Guardar la location si el usuario existe
            return reservaRepository.save(location);
        } else {
            // Lanzar una excepción si el usuario no existe
            throw new IllegalArgumentException("El usuario con ID " + location.getUsuarioId() + " no existe.");
        }
    }


    @Override
    public Location update(String id, Location location) {
        // Buscar la location existente por su ID
        Location existingReserva = reservaRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Reserva con ID " + id + " no encontrada.")
        );

        // Validar si se ha proporcionado un nuevo usuarioId y si el usuario existe en la BD
        if (location.getUsuarioId() != null) {
            Optional<Usuario> usuario = usuarioRepository.findById(location.getUsuarioId());
            if (usuario.isPresent()) {
                existingReserva.setUsuarioId(location.getUsuarioId());
            } else {
                throw new IllegalArgumentException("El usuario con ID " + location.getUsuarioId() + " no existe.");
            }
        }


        // Guardar la location actualizada
        return reservaRepository.save(existingReserva);
    }


    @Override
    public void deleteById(String id) {
        reservaRepository.deleteById(id);
    }



    public LocationResponseDto getLocationById(String locationId) {
        // Buscar la reserva por su ID
        Optional<Location> reservaOpt = reservaRepository.findById(locationId);
        if (reservaOpt.isPresent()) {
            Location reserva = reservaOpt.get();

            // Buscar el usuario por el usuarioId en la reserva
            Optional<Usuario> usuarioOpt = usuarioRepository.findById(reserva.getUsuarioId());
            if (usuarioOpt.isPresent()) {
                Usuario usuario = usuarioOpt.get();

                // Crear y devolver el DTO de respuesta con los datos del usuario
                return new LocationResponseDto(reserva.getId(), usuario);
            } else {
                throw new IllegalArgumentException("Usuario no encontrado para la reserva.");
            }
        } else {
            throw new IllegalArgumentException("Reserva no encontrada.");
        }
    }



}
