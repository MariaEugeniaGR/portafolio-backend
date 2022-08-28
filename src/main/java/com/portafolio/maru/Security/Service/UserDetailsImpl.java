/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Security.Service;

import com.portafolio.maru.Security.Entity.Usuario;
import com.portafolio.maru.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nameUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNameUsuario(nameUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }  
}
