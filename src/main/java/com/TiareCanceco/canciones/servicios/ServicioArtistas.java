package com.TiareCanceco.canciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TiareCanceco.canciones.modelos.Artista;
import com.TiareCanceco.canciones.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {

    @Autowired
    private RepositorioArtistas repo;

    public List<Artista> obtenerTodosLosArtistas() {
        return repo.findAll();
    }

    public Artista obtenerArtistaPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Artista agregarArtista(Artista artista) {
        return repo.save(artista);
    }
}
    

