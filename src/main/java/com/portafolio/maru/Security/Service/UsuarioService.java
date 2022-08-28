/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Security.Service;

import com.portafolio.maru.Security.Entity.Usuario;
import com.portafolio.maru.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNameUsuario(String nameUsuario){
        return iusuarioRepository.findByNameUsuario(nameUsuario);
    }
    
    public boolean existsByNameUsuario(String nameUsuario){
        return iusuarioRepository.existsByNameUsuario(nameUsuario);
    }
    
     public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    } 
     
     public void save(Usuario usuario){
         iusuarioRepository.save(usuario);
     }
}
