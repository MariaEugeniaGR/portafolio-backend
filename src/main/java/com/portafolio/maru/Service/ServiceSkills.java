/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Service;

import com.portafolio.maru.Entity.Skills;
import com.portafolio.maru.Repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceSkills {
    @Autowired
    RSkills rSkills;
    
    public List<Skills> list(){
        return rSkills.findAll();
    }
    
    public Optional<Skills> getOne(int id){
        return rSkills.findById(id);
    }
    
    public Optional<Skills> getByNameSkill(String nameSkill){
        return rSkills.findByNameSkill(nameSkill);
    }
    
    public void save(Skills skills){
        rSkills.save(skills);
    }
    
    public void delete(int id){
        rSkills.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSkills.existsById(id);
    }
    
    public boolean existsByNameSkill(String nameSkill){
        return rSkills.existsByNameSkill(nameSkill);
    }
}
