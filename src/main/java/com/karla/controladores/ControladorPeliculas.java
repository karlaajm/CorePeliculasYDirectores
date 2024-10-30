package com.karla.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPeliculas {
    private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();

    public ControladorPeliculas() {
        listaPeliculas.put("Winnie the Pooh", "Don Hall");
        listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
        listaPeliculas.put("Tarzán", "Kevin Lima");
        listaPeliculas.put("Mulán", "Barry Cook");
        listaPeliculas.put("Oliver", "Kevin Lima");
        listaPeliculas.put("Big Hero 6", "Don Hall");
    }

    @GetMapping("/peliculas") 
    public HashMap<String, String> obtenerTodasLasPeliculas() {
        return listaPeliculas;
    }

    @GetMapping("/peliculas/{nombre}") 
    public String obtenerPeliculaPorNombre(@PathVariable String nombre ) {
        if (listaPeliculas.get(nombre) != null) {
            return "Pelicula: " + nombre + ", Director: " + listaPeliculas.get(nombre);
        }else {
            return "La pelicula no se encuentra en nuestra lista";
        }

    }

    @GetMapping("/peliculas/director/{nombre}")
    public String obtenerPeliculasPorDirector(@PathVariable String nombre ) {
        List<String> peliculas = new ArrayList <>(); 

        for(String peliculasPorDirector : listaPeliculas.keySet()) {
            if(listaPeliculas.get(peliculasPorDirector).equals(nombre) ) {
                peliculas.add(peliculasPorDirector);
            }

        }
        if(peliculas.isEmpty()) {
            return "No contamos con películas con ese director en nuestra lista.";
        }else {
            return "Películas dirigidas por " + nombre + ": " + peliculas;
        }
    }

}