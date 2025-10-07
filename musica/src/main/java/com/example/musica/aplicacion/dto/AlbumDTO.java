package com.example.musica.aplicacion.dto;

import java.time.LocalDateTime;

public class AlbumDTO {

    private Long id;
    private String titulo;
    private LocalDateTime fechaLanzamiento;
    private String genero;
    private Long artistaId;

    public AlbumDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDateTime fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(Long artistaId) {
        this.artistaId = artistaId;
    }
}
