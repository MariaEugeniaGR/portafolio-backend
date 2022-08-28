/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyecto {
    @NotBlank
    private String nameP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String imagenP;

    public DtoProyecto() {
    }

    public DtoProyecto(String nameP, String descripcionP, String imagenP) {
        this.nameP = nameP;
        this.descripcionP = descripcionP;
        this.imagenP = imagenP;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImagenP() {
        return imagenP;
    }

    public void setImagenP(String imagenP) {
        this.imagenP = imagenP;
    }
}
