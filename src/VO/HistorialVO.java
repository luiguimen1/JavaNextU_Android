/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Lic. Luis Eduardo Alvarez Meneses
 */
public class HistorialVO {
    private int cod;
    private String fec;
    private int idP;
    private int idM;
    private String obs;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public HistorialVO() {
    }

    public HistorialVO(int cod, String fec, int idP, int idM, String obs) {
        this.cod = cod;
        this.fec = fec;
        this.idP = idP;
        this.idM = idM;
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Código=" + cod + " " + fec + " " + idP + " " + idM + " " + obs ;
    }
}
