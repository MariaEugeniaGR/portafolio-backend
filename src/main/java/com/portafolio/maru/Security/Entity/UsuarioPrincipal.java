/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Security.Entity;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 *
 * @author familia
 */
public class UsuarioPrincipal implements UserDetails {
    private String name;
    private String nameUsuario;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    
    //Constructor

    public UsuarioPrincipal(String name, String nameUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.nameUsuario = nameUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(Usuario usuario){
         List<GrantedAuthority>authorities = usuario.getRoles().stream()
                 .map(rol -> new SimpleGrantedAuthority(rol.getRolName().name())).collect(Collectors
                 .toList());
        return new UsuarioPrincipal(usuario.getName(), usuario.getNameUsuario(), usuario.getEmail()
                , usuario.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nameUsuario;
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    
}
