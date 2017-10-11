/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Storage.BD;
import VO.MedicoVO;
import java.util.ArrayList;

/**
 *
 * @author Lic. Luis Eduardo Alvarez Meneses
 */
public class MedicoDAO {
    private BD agenda = new BD();

    /**
     * Metodo que permite alamcenar un paciente en la base de datos, pero
     * primero verifica que la identificación del paciente no este repetida
     *
     * @param id
     * @param nombre
     * @param apellido
     * @param edad
     * @param genero
     * @return
     */
    public boolean agregar(int id, String nombre, String apellido, String esp) {
        MedicoVO nuevo = new MedicoVO(id, nombre, apellido, esp);
        if (buscar(nuevo.getId()) == null) {
            agenda.almacenar(nuevo);
            return true;
        }
        return false;
    }

    /**
     * Metodo que permite Buscar si un paciente esta en la base de datos si no
     * esta retorna null
     *
     * @param id
     * @return
     */
    public MedicoVO buscar(int id) {
        MedicoVO tmp = null;
        ArrayList todos = agenda.getBD();
        for (int i = 0; i < agenda.getContador(); i++) {
            MedicoVO tmpLocal = (MedicoVO) todos.get(i);
            if (tmpLocal.getId() == id) {
                return tmpLocal;
            }
        }
        return tmp;
    }

    public String Lista() {
        String Listado = "Listado de Pacientes\n";
        ArrayList todos = agenda.getBD();
        for (int i = 0; i < agenda.getContador(); i++) {
            MedicoVO tmpLocal = (MedicoVO) todos.get(i);
            Listado += "POS (" + (i + 1) + ") " + tmpLocal.toString() + "\n";
        }
        return Listado;
    }

    public boolean remover(int pos) {
        if (agenda.Elimar(pos) != null) {
            return true;
        }
        return false;
    }

    public int size() {
        return agenda.getContador();
    }
}
