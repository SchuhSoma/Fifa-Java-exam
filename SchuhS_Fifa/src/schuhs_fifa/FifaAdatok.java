/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuhs_fifa;

/**
 *
 * @author Soma
 */
public class FifaAdatok
{
    public String Csapat;
    public int Helyezes;
    public int Valtozas;
    public int Pontszam;

    public FifaAdatok(String Csapat, int Helyezes, int Valtozas, int Pontszam) {
        this.Csapat = Csapat;
        this.Helyezes = Helyezes;
        this.Valtozas = Valtozas;
        this.Pontszam = Pontszam;
    }

    public String getCsapat() {
        return Csapat;
    }

    public void setCsapat(String Csapat) {
        this.Csapat = Csapat;
    }

    public int getHelyezes() {
        return Helyezes;
    }

    public void setHelyezes(int Helyezes) {
        this.Helyezes = Helyezes;
    }

    public int getValtozas() {
        return Valtozas;
    }

    public void setValtozas(int Valtozas) {
        this.Valtozas = Valtozas;
    }

    public int getPontszam() {
        return Pontszam;
    }

    public void setPontszam(int Pontszam) {
        this.Pontszam = Pontszam;
    }
    
}
