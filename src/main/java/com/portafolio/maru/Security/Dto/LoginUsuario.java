/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Security.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author familia
 */
public class LoginUsuario {

    @NotBlank
    private String nameUsuario;
    @NotBlank
    private String password;
    
    //Getter y Setter

    public String getNameUsuario() {
        return nameUsuario;
    }

    public void setNameUsuario(String nameUsuario) {
        this.nameUsuario = nameUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
