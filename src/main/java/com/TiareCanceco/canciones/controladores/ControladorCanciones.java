package com.TiareCanceco.canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.TiareCanceco.canciones.modelos.Cancion;



import com.TiareCanceco.canciones.servicios.ServicioCanciones;

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

        System.out.println("CREATED AT → " + cancion.getFechaCreacion());
        System.out.println("UPDATED AT → " + cancion.getFechaActualizacion());
        
        
        
        modelo.addAttribute("cancion", servicio.obtenerCancionPorId(idCancion));
        return "detalleCancion.jsp";

        
    }

    

}
