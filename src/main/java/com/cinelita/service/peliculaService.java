/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinelita.service;

import com.cinelita.entity.pelicula;
import com.cinelita.repository.pelicularepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ysilva
 */
@Service
public class peliculaService implements IpeliculaService{
     @Autowired
     private pelicularepository peliculaRepository;
     
    @Override
    public List<pelicula> getAllpelicula() {
      return (List<pelicula>) peliculaRepository.findAll ();
    }

    @Override
    public pelicula getpeliculaById(long id) {
     return peliculaRepository.findById(id).orElse(null);  
    }

    @Override
    public void savepelicula(pelicula pelicula) {
      peliculaRepository.save (pelicula);  
    }

    @Override
    public void delete(long id) {
    peliculaRepository.deleteById(id);    
    
}
}