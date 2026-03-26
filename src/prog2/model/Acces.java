package prog2.model;

import java.util.ArrayList;

public abstract class Acces implements InAcces{
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;

    public Acces(String nom, boolean accesibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments){
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = estat;
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) {

    }

    @Override
    public void tancarAcces() {

    }

    @Override
    public void obrirAcces() {

    }

    @Override
    public String getNom() {
        return "";
    }

    @Override
    public boolean getEstat() {
        return false;
    }

    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return null;
    }

    public String toString(){
        return "";
    }
}
