/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
     private String nameE;
    @NotBlank
    private String descripcionE;
    
    //Constructores

    public dtoEducacion() {
    }

    public dtoEducacion(String nameE, String descripcionE) {
        this.nameE = nameE;
        this.descripcionE = descripcionE;
    }
    
    //Getter y Setter

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
}
