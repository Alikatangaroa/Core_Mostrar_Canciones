package com.TiareCanceco.canciones.modelos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDate;


    
@Entity
@Table(name = "canciones")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String titulo;
        private String artista;
        private String album;
        private String genero;
        private String idioma;

    @Column(name = "fechaCreacion", updatable = false)
    private LocalDate fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDate fechaActualizacion;

    
    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDate.now();
        this.fechaActualizacion = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = LocalDate.now();
    }

    public Cancion() {}

    public Long getId() {
        return id;
        }

    public String getTitulo() {
        return titulo;
        }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
        }

    public String getArtista() {
        return artista;
        }

    public void setArtista(String artista) {
        this.artista = artista;
        }

    public String getAlbum() {
        return album;
        }

    public void setAlbum(String album) {
        this.album = album;
        }

    public String getGenero() {
        return genero;  
        }

    public void setGenero(String genero) {
        this.genero = genero;
        }

    public String getIdioma() {
        return idioma;
        }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
        }

    public LocalDate getFechaCreacion() { 
        return fechaCreacion; 
    }
    public void setFechaCreacion(LocalDate fechaCreacion) { 
        this.fechaCreacion = fechaCreacion; 
    }

    public LocalDate getFechaActualizacion() { 
        return fechaActualizacion; 
    }
    public void setFechaActualizacion(LocalDate fechaActualizacion) { 
        this.fechaActualizacion = fechaActualizacion; 
    }

}
