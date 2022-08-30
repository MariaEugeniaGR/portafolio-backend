/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Controller;

import com.portafolio.maru.Dto.DtoSkills;
import com.portafolio.maru.Entity.Skills;
import com.portafolio.maru.Security.Controller.Mensaje;
import com.portafolio.maru.Service.ServiceSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "*")
public class CSkills {
    @Autowired
    ServiceSkills serviceSkills;
    
    @GetMapping("/lista")
  public ResponseEntity<List<Skills>> list(){
      List<Skills> list = serviceSkills.list();
      return new ResponseEntity(list, HttpStatus.OK);
  }  
  
   @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!serviceSkills.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skills skills = serviceSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!serviceSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        serviceSkills.delete(id);
        return new ResponseEntity(new Mensaje("skill eliminada"), HttpStatus.OK);
    }
    
  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody DtoSkills dtoSkills){
      if(StringUtils.isBlank(dtoSkills.getNameSkill()))
          return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      if(serviceSkills.existsByNameSkill(dtoSkills.getNameSkill()))
          return new ResponseEntity(new Mensaje("Esa skill existe"), HttpStatus.BAD_REQUEST);
      
    Skills skills = new Skills(dtoSkills.getNameSkill(), dtoSkills.getFotoSkill(), dtoSkills.getPorcentaje());
    serviceSkills.save(skills);
    
    return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
  }
  
  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtoSkills){
      //Validamos si existe el ID
      if(!serviceSkills.existsById(id))
          return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
      //Compara nombre de experiencia
      if(serviceSkills.existsByNameSkill(dtoSkills.getNameSkill()) && serviceSkills.getByNameSkill(dtoSkills.getNameSkill()).get().getId() != id)
          return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
      //No puede estar vacio
      if(StringUtils.isBlank(dtoSkills.getNameSkill()))
          return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      
      Skills skills = serviceSkills.getOne(id).get();
      skills.setNameSkill(dtoSkills.getNameSkill());
      skills.setFotoSkill((dtoSkills.getFotoSkill()));
      skills.setPorcentaje((dtoSkills.getPorcentaje()));
  
      serviceSkills.save(skills);
      return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
  }
}

  