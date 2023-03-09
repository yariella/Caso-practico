/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinelita.service;

import com.cinelita.entity.sala;
import com.cinelita.repository.salarepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ysilva
 */
@Service
public class salaService implements IsalaService{
   @Autowired 
    private salarepository salaRepository;
   
    @Override
    public List<sala> buscartodos() {
       return (List<sala>)salaRepository.findAll (); }
    
    
}
