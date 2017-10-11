/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import Astracta.Persona;

/**
 *
 * @author Lic. Luis Eduardo Alvarez Meneses
 */
public class MedicoVO extends Persona {

    private String esp;

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }

    public MedicoVO(int id, String nombre, String apellido, String esp) {
        super(id, nombre, apellido);
        this.esp = esp;
    }

    public MedicoVO() {
    }

    @Override
    public String toString() {
        return " ID =(" + this.getId() + ") " + this.getApellido() + " " + this.getNombre() + " " + esp;
    }

}
