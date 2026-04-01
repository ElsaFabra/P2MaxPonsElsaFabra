package prog2.model;

import java.util.ArrayList;

public abstract class Acces implements InAcces{
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;

    public Acces(String nom, boolean accesibilitat, boolean estat, ArrayList<Allotjament> allotjaments) {
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = estat;
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
        return "Nom: " + nom + ", Accesibilitat: " + accesibilitat + ", Estat: " + estat + ", Allotjaments: " + allotjaments;
    }

    @Override
    public boolean isAccessibilitat() {
        return accesibilitat;
    }
}
