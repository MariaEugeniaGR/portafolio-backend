/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Controller;

import com.portafolio.maru.Dto.dtoEducacion;
import com.portafolio.maru.Entity.Educacion;
import com.portafolio.maru.Security.Controller.Mensaje;
import java.util.List;
import com.portafolio.maru.Service.Seducacion;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    Seducacion sEducacion;
    
    @GetMapping("/lista")
    public  ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
         if(!sEducacion.existsById(id)){
          return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
    }
      Educacion educacion = sEducacion.getOne(id).get();
      return new ResponseEntity(educacion, HttpStatus.OK);    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
      if(!sEducacion.existsById(id)){
          return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
    }
      sEducacion.delete(id);
      return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
      if(StringUtils.isBlank(dtoeducacion.getNameE())){
          return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      }
      if(sEducacion.existsByNameE(dtoeducacion.getNameE())){
          return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
      }
    Educacion educacion = new Educacion(
            dtoeducacion.getNameE(), dtoeducacion.getDescripcionE()
    );
    sEducacion.save(educacion);
    return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
      }
      
  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
      if(!sEducacion.existsById(id)){
          return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
      }
      if(sEducacion.existsByNameE(dtoeducacion.getNameE()) && sEducacion.getByNameE(dtoeducacion.getNameE()).get().getId() != id){
          return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
      }
      if(StringUtils.isBlank(dtoeducacion.getNameE())){
          return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
      }
 
      Educacion educacion = sEducacion.getOne(id).get();
      
      educacion.setNameE(dtoeducacion.getNameE());
      educacion.setDescripcionE(dtoeducacion.getDescripcionE());
  
      sEducacion.save(educacion);
      return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
  }
}
