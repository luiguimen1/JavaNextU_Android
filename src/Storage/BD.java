/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import java.util.ArrayList;

/**
 *
 * @author Lic. Luis Eduardo Alvarez Meneses
 */
public class BD {

    private ArrayList BD;
    private int contador;

    public void almacenar(Object Tmp) {
        BD.add(Tmp);
        contador += 1;
    }

    public ArrayList getBD() {
        return BD;
    }

    public int getContador() {
        return contador;
    }

    public Object Elimar(int post) {
        try {
            Object tmp = BD.remove(post);
            contador -= 1;
            return tmp;
        } catch (Exception e) {
            return null;
        }
    }

    public BD() {
        this.BD = new ArrayList();
        this.contador = 0;
    }

}
