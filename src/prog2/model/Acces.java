package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Acces implements InAcces, Serializable {
    private String nom;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;

    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.allotjaments = new ArrayList<>();

    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        allotjaments.add(allotjament);
    }

    @Override
    public void tancarAcces() {
        estat = false;
    }

    @Override
    public void obrirAcces() {
        estat = true;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public boolean getEstat() {
        return estat;
    }

    public void setEstat(boolean estat){
        this.estat = estat;
    }

    @Override
    public LlistaAllotjaments getAAllotjaments() {
        LlistaAllotjaments llista = new LlistaAllotjaments();
        for (Allotjament a : allotjaments) {
            llista.afegirAllotjament(a);
        }
        return llista;
    }

    // elsa no se si al toString els allotjaments s'ha de posar aixi (està al final):
    public String toString(){
        return "Acces{nom=" + nom + ", estat=" + estat + "}";
    }

    @Override
    public abstract boolean isAccessibilitat();

}
