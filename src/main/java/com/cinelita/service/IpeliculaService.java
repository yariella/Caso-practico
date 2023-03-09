/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinelita.service;

import com.cinelita.entity.pelicula;
import java.util.List;

/**
 *
 * @author ysilva
 */
public interface IpeliculaService {
    public List<pelicula> getAllpelicula ();
    public pelicula getpeliculaById (long id);
    public void savepelicula (pelicula pelicula);
    public void delete (long id);   
}
