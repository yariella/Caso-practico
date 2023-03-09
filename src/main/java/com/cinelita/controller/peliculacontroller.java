/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinelita.controller;

import com.cinelita.entity.pelicula;
import com.cinelita.entity.sala;
import com.cinelita.service.IpeliculaService;
import com.cinelita.service.IsalaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ysilva
 */
@Controller
public class peliculacontroller {
@Autowired
    private IpeliculaService peliculaService;
    
    @Autowired
    private IsalaService salaService;
    
    @GetMapping("/pelicula")
    public String index(Model model){
        List<pelicula> listapelicula = peliculaService.getAllpelicula();
        model.addAttribute("titulo", "Tabla pelicula");
        model.addAttribute("pelicula", listapelicula);
        return "pelicula";
    }
    
    @GetMapping("/peliculaN")
    public String crearpelicula(Model model){
        List<sala> listasala = salaService.buscartodos();
        model.addAttribute("pelicula", new pelicula());
        model.addAttribute("salas", listasala);
        return "crear";
    }
    
    
     @GetMapping("/delete/{id}")
    public String eliminarpelicula(@PathVariable("id") Long idpelicula){
        peliculaService.delete(idpelicula);
        return  "redirect:/pelicula";
    }
    
    
    @PostMapping("/save")
    public String guardarpelicula(@ModelAttribute pelicula pelicula){
    peliculaService.savepelicula(pelicula);
    return "redirect:/pelicula";
    }
    
    @GetMapping("/editpelicula/{id}")
    public String editarpelicula(@PathVariable("id") Long idpelicula, Model model){
    pelicula pelicula = peliculaService.getpeliculaById(idpelicula);
    List<sala> listasala = salaService.buscartodos();
    model.addAttribute("pelicula", pelicula);
    model.addAttribute("salas", listasala);
    return  "crear";
    }
}
