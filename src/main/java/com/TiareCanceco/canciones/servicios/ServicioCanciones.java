package com.TiareCanceco.canciones.servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TiareCanceco.canciones.repositorios.RepositorioCanciones;
import com.TiareCanceco.canciones.modelos.Cancion;
import java.util.List;


@Service
public class ServicioCanciones {

    @Autowired
    private RepositorioCanciones repo;

    public List<Cancion> obtenerTodasLasCanciones() {
        return repo.findAll();
    }

    public Cancion obtenerCancionPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Cancion agregarCancion(Cancion cancion) {
        return repo.save(cancion);
    }
}
