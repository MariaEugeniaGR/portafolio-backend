/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.maru.Repository;

import com.portafolio.maru.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RSkills extends JpaRepository<Skills,Integer>{
     public Optional<Skills> findByNameSkill(String nameSkill);
    public boolean existsByNameSkill(String nameSkill);
}
