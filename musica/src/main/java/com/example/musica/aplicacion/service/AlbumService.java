package com.example.musica.aplicacion.service;

import com.example.musica.aplicacion.dto.AlbumDTO;
import com.example.musica.aplicacion.mapper.AlbumMapper;
import com.example.musica.infraestructura.model.Album;
import com.example.musica.infraestructura.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    public AlbumService(AlbumRepository albumRepository, AlbumMapper albumMapper) {
        this.albumRepository = albumRepository;
        this.albumMapper = albumMapper;
    }

    public AlbumDTO crearAlbum(AlbumDTO dto) {
        Album album = albumMapper.toEntity(dto);
        return albumMapper.toDto(albumRepository.save(album));
    }

    public List<AlbumDTO> listarAlbums() {
        return albumRepository.findAll().stream()
                .map(albumMapper::toDto)
                .collect(Collectors.toList());
    }

    public AlbumDTO obtenerAlbum(Long id) {
        return albumRepository.findById(id)
                .map(albumMapper::toDto)
                .orElse(null);
    }

    public void eliminarAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
