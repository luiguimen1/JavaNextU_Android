/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JOptionPane;

/**
 *
 * @author Lic. Luis Eduardo Alvarez Meneses
 */
public class Pantalla {

        public char capChar(String MSN) {
            return JOptionPane.showInputDialog(null, MSN).toCharArray()[0];
        }

        public String capString(String MSN) {
            return JOptionPane.showInputDialog(null, MSN);
        }

        public void mensaje(String MNS) {
            JOptionPane.showMessageDialog(null, MNS);
        }

        public void mensajeError(String MNS) {
            JOptionPane.showMessageDialog(null, MNS, "Error", JOptionPane.ERROR_MESSAGE);
        }

        public int capInt(String MSN) {
            try {
                return Integer.parseInt(capString(MSN));
            } catch (Exception e) {
                mensajeError("El dato no es valido");
                return capInt(MSN);
            }
        }

        public String capStrDefi(String MSN, String Defecto) {
            return JOptionPane.showInputDialog(MSN, Defecto);
        }

        public int capIntDefi(String MSN, String Defecto) {
            try {
                return Integer.parseInt(capStrDefi(MSN, Defecto));
            } catch (Exception e) {
                mensajeError("Dato no valido");
                return capIntDefi(MSN, Defecto);
            }
        }

        public char genero() {
            String[] Genero = {"Seleccione", "F", "M"};
            String g = (String) JOptionPane.showInputDialog(null, "Seleccione un Genero", "Genero", JOptionPane.DEFAULT_OPTION, null, Genero, Genero[0]);
            char Seleccion = g.charAt(0);
            if (Seleccion == 'S') {
                mensajeError("Debe Selecionar un genero");
                return genero();
            } else {
                return Seleccion;
            }
        }
    }