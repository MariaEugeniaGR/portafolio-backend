/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author familia
 */
public class DtoSkills {
      @NotBlank
    private String nameSkill;
      @NotBlank
    private String fotoSkill;
      @NotBlank
    private int porcentaje;

    public DtoSkills() {
    }

    public DtoSkills(String nameSkill, String fotoSkill, int porcentaje) {
        this.nameSkill = nameSkill;
        this.fotoSkill = fotoSkill;
        this.porcentaje = porcentaje;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public String getFotoSkill() {
        return fotoSkill;
    }

    public void setFotoSkill(String fotoSkill) {
        this.fotoSkill = fotoSkill;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
       
}
