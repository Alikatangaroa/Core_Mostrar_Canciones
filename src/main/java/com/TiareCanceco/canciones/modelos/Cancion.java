package com.TiareCanceco.canciones.modelos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import java.time.LocalDateTime;



    
@Entity
@Table(name = "canciones")
public class Cancion {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @NotBlank(message="El título es obligatorio")
        @Size(min=5, message="El título debe tener al menos 5 caracteres")
        private String titulo;

        
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "artista_id")
        private Artista artista;

        @NotBlank(message="El album es obligatorio")
        @Size(min=3, message="El album debe tener al menos 3 caracteres")
        private String album;

        @NotBlank(message="El genero es obligatorio")
        @Size(min=3, message="El genero debe tener al menos 3 caracteres")
        private String genero;

        @NotBlank(message="El idioma es obligatorio")
        @Size(min=3, message="El idioma debe tener al menos 3 caracteres")
        private String idioma;

        @Column(name = "fecha_creacion", updatable = false)
        private LocalDateTime fechaCreacion;

        @Column(name = "fecha_actualizacion")
        private LocalDateTime fechaActualizacion;

    
    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }

    public Cancion() {}

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

    public Artista getArtista() {
        return artista;
        }

    public void setArtista(Artista artista) {
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

    public LocalDateTime getFechaCreacion() { 
        return fechaCreacion; 
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { 
        this.fechaCreacion = fechaCreacion; 
    }

    public LocalDateTime getFechaActualizacion() { 
        return fechaActualizacion; 
    }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) { 
        this.fechaActualizacion = fechaActualizacion; 
    }

}
