package com.TiareCanceco.canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import com.TiareCanceco.canciones.modelos.Artista;
import com.TiareCanceco.canciones.modelos.Cancion;
import com.TiareCanceco.canciones.servicios.ServicioArtistas;
import com.TiareCanceco.canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioArtistas servicioArtistas;

    @Autowired
    private ServicioCanciones servicio;

    //  Metodo para mostrar todas las canciones
    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo) {
        modelo.addAttribute("listaCanciones", servicio.obtenerTodasLasCanciones());
        return "canciones.jsp";
    }

    // Metodo para mostrar el detalle cancion segun su ID
    @GetMapping("/canciones/detalle/{idCancion}")
    public String detalle(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = servicio.obtenerCancionPorId(idCancion); 
        if(cancion == null){
            return "redirect:/canciones";
        }      
        modelo.addAttribute("cancion", cancion);
        return "detalleCancion.jsp";
        
    }

    // Formulario
    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion, Model modelo) {
        modelo.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
        @Valid @ModelAttribute("cancion") Cancion cancion,
        BindingResult result,
        @RequestParam(value="idArtista", required=false) Long idArtista, Model modelo) {

        System.out.println("DEBUG idArtista => [" + idArtista + "]");
        System.out.println("DEBUG hasErrors => " + result.hasErrors());

     if (idArtista == null) {
        result.rejectValue("artista", "error.artista", "Debes seleccionar un artista");
    } else {
        Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
        if (artista == null){
            result.rejectValue("artista", "error.artista", "Debes seleccionar un artista valido");
    } else {
        cancion.setArtista(artista);
    }
    }
    
    
    if (result.hasErrors()) {
        modelo.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion.jsp";
    }

    servicio.agregarCancion(cancion);
    return "redirect:/canciones";
    }

    // Formulario editar

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = servicio.obtenerCancionPorId(idCancion);
        if (cancion == null) 
            return "redirect:/canciones";

        modelo.addAttribute("cancion", cancion);
        modelo.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
            return "editarCancion.jsp";
    }

    // Procesar editar (PUT)

    @PutMapping("/canciones/procesa/editar/{idCancion}")
    public String editarCancion(@PathVariable ("idCancion") Long idCancion,
                                @Valid @ModelAttribute("cancion") Cancion cancionForm,
                                BindingResult validaciones,
                                @RequestParam("idArtista") Long idArtista, Model modelo) {
                                        
        if (validaciones.hasErrors()){
            modelo.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
                return "editarCancion.jsp";
        }
    
        Cancion existente = servicio.obtenerCancionPorId(idCancion);
            if(existente == null) 
                return "redirect:/canciones";
        
        Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
            if (artista == null) {
                modelo.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
                validaciones.rejectValue("artista", "error.artista", "Debes seleccionar un artista válido");
                return "editarCancion.jsp";
            }

        existente.setTitulo(cancionForm.getTitulo());
        existente.setAlbum(cancionForm.getAlbum());
        existente.setArtista(artista);
        existente.setGenero(cancionForm.getGenero());
        existente.setIdioma(cancionForm.getIdioma());

        servicio.actualizaCancion(existente);
        return "redirect:/canciones";

    }

    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
        servicio.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }
}
