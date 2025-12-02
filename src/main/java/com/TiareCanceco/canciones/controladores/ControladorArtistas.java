package com.TiareCanceco.canciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.TiareCanceco.canciones.modelos.Artista;
import com.TiareCanceco.canciones.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {

    @Autowired
    private ServicioArtistas servicioArtistas;

    @GetMapping("/artistas")
    public String desplegarArtistas(Model modelo) {
        List<Artista> lista = servicioArtistas.obtenerTodosLosArtistas();
        modelo.addAttribute("listaArtistas", lista);
        return "artistas.jsp";
    }

    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable Long idArtista, Model modelo) {
        Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
        if (artista == null) {
            return "redirect:/artistas";
        }
        modelo.addAttribute("artista", artista);
        return "detalleArtista.jsp";
    }

    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(@ModelAttribute("artista") Artista artista) {
        return "agregarArtista.jsp";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista,
                                        BindingResult result) {

        if (result.hasErrors()) {
            return "agregarArtista.jsp";
        }

        servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";
    }
}