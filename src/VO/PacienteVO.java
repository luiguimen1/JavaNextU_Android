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
public class PacienteVO extends Persona {

    private int edad;
    private char genero;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public PacienteVO(int id, String nombre, String apellido, int edad, char genero) {
        super(id, nombre, apellido);
        this.edad = edad;
        this.genero = genero;
    }

    public PacienteVO() {
    }

    @Override
    public String toString() {
        return "id=("+this.getId() + ") " + this.getApellido() + " " + this.getNombre() + " " + edad + " " + genero;
    }

}
