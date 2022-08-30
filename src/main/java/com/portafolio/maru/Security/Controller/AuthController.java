/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Security.Controller;

import com.portafolio.maru.Security.Dto.JwtDto;
import com.portafolio.maru.Security.Dto.LoginUsuario;
import com.portafolio.maru.Security.Dto.NuevoUsuario;
import com.portafolio.maru.Security.Entity.Rol;
import com.portafolio.maru.Security.Entity.Usuario;
import com.portafolio.maru.Security.Enums.RolName;
import com.portafolio.maru.Security.Service.RolService;
import com.portafolio.maru.Security.Service.UsuarioService;
import com.portafolio.maru.Security.jwt.JwtProvider;
import java.util.Set;
import java.util.HashSet;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;  
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService; 
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
        
        if(usuarioService.existsByNameUsuario(nuevoUsuario.getNameUsuario()))
            return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        
        Usuario usuario = new Usuario(nuevoUsuario.getName(), nuevoUsuario.getNameUsuario(),
                nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
            if(bindingResult.hasErrors())
    return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
            
            
            UsernamePasswordAuthenticationToken userLogin = new UsernamePasswordAuthenticationToken(loginUsuario.getNameUsuario(), loginUsuario.getPassword());
            Authentication authentication = authenticationManager.authenticate(userLogin);
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            String jwt = jwtProvider.generateToken(authentication);
            
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            
            JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
            
            return new ResponseEntity(jwtDto, HttpStatus.OK);   
    }
}
