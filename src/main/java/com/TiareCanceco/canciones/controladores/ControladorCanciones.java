package com.TiareCanceco.canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.TiareCanceco.canciones.modelos.Cancion;

import com.TiareCanceco.canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

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
        modelo.addAttribute("cancion", servicio.obtenerCancionPorId(idCancion));
        return "detalleCancion.jsp";
        
    }

    // Formulario

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion) {
        return "agregarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
        @Valid @ModelAttribute("cancion") Cancion cancion,
        BindingResult result) {
    if (result.hasErrors()) {
        return "agregarCancion.jsp";
    }
    servicio.agregarCancion(cancion);
    return "redirect:/canciones";
    }

    @GetMapping("/canciones/formulario/agregar/{idCancion}")
    public String formularioAgregarCancionConId(@PathVariable Long idCancion,
                                                @ModelAttribute("cancion")Cancion cancion){
        return "agregarCancion.jsp";
    }

    // Formulario editar

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = servicio.obtenerCancionPorId(idCancion);
        if (cancion == null){
            return "redirect:/canciones";
        }
        modelo.addAttribute("cancion", cancion);
        return "editarCancion.jsp";
    }

    // Procesar editar (PUT)

    @PutMapping("/canciones/procesa/editar/{idCancion}")
    public String editarCancion(@PathVariable ("idCancion") Long idCancion,
                                @Valid @ModelAttribute("cancion") Cancion cancionForm,
                                BindingResult validaciones) {
                                        
        if (validaciones.hasErrors()){
            return "editarCancion.jsp";
        }
    
        Cancion existente = servicio.obtenerCancionPorId(idCancion);
            if(existente == null) 
                return "redirect:/canciones";

        existente.setTitulo(cancionForm.getTitulo());
        existente.setArtista(cancionForm.getArtista());
        existente.setAlbum(cancionForm.getAlbum());
        existente.setGenero(cancionForm.getGenero());
        existente.setIdioma(cancionForm.getIdioma());

        servicio.actualizaCancion(existente);
        return "redirect:/canciones";

    }

    


}
