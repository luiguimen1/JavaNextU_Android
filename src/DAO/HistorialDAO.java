/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Storage.BD;
import VO.HistorialVO;
import java.util.ArrayList;


/**
 *
 * @author Lic. Luis Eduardo Alvarez Meneses
 */
public class HistorialDAO {
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
    public boolean agregar(int cod, String fec, int idP, int idM, String obs) {
        HistorialVO nuevo = new HistorialVO(cod, fec, idP, idM, obs);
        if (buscar(nuevo.getCod()) == null) {
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
    public HistorialVO buscar(int cod) {
        HistorialVO tmp = null;
        ArrayList todos = agenda.getBD();
        for (int i = 0; i < agenda.getContador(); i++) {
            HistorialVO tmpLocal = (HistorialVO) todos.get(i);
            if (tmpLocal.getCod() == cod) {
                return tmpLocal;
            }
        }
        return tmp;
    }

    public String Lista() {
        String Listado = "Listado de Pacientes\n";
        ArrayList todos = agenda.getBD();
        for (int i = 0; i < agenda.getContador(); i++) {
            HistorialVO tmpLocal = (HistorialVO) todos.get(i);
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
