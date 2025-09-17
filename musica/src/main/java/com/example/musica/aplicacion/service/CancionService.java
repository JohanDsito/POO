package com.example.musica.aplicacion.service;

import com.example.musica.aplicacion.dto.CancionDTO;
import com.example.musica.aplicacion.mapper.CancionMapper;
import com.example.musica.infraestructura.model.Cancion;
import com.example.musica.infraestructura.repository.CancionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CancionService {

    private final CancionRepository cancionRepository;
    private final CancionMapper cancionMapper;

    public CancionService(CancionRepository cancionRepository, CancionMapper cancionMapper) {
        this.cancionRepository = cancionRepository;
        this.cancionMapper = cancionMapper;
    }

    public CancionDTO crearCancion(CancionDTO dto) {
        Cancion cancion = cancionMapper.toEntity(dto);
        return cancionMapper.toDto(cancionRepository.save(cancion));
    }

    public List<CancionDTO> listarCanciones() {
        return cancionRepository.findAll().stream()
                .map(cancionMapper::toDto)
                .collect(Collectors.toList());
    }

    public CancionDTO obtenerCancion(Long id) {
        return cancionRepository.findById(id)
                .map(cancionMapper::toDto)
                .orElse(null);
    }

    public void eliminarCancion(Long id) {
        cancionRepository.deleteById(id);
    }
}
