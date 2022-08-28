/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Service;

import com.portafolio.maru.Entity.Proyecto;
import com.portafolio.maru.Repository.RProyecto;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SProyecto {
   
@Autowired
    RProyecto rProyecto;
    
    public List<Proyecto> list(){
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByNameP(String nameP){
        return rProyecto.findByNameP(nameP);
    }
    
    public void save(Proyecto proyecto){
        rProyecto.save(proyecto);
    }
    
    public void delete(int id){
        rProyecto.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyecto.existsById(id);
    }
    
    public boolean existsByNameP(String nameP){
        return rProyecto.existsByNameP(nameP);
    }
}