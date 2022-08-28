/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Security.Service;

import com.portafolio.maru.Security.Entity.Rol;
import com.portafolio.maru.Security.Enums.RolName;
import com.portafolio.maru.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolName(RolName rolName){
        return irolRepository.findByRolName(rolName);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
