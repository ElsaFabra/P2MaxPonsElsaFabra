package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe abstracta que representa un accés al càmping.
 * Conté els atributs comuns a tots els accessos: nom, estat i llista d'allotjaments.
 * Les subclasses han d'implementar el mètode {@link #isAccessibilitat()}.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public abstract class Acces implements InAcces, Serializable {

    /** Nom identificador de l'accés. */
    private String nom;

    /** Estat de l'accés: true si està obert, false si està tancat. */
    private boolean estat;

    /** Llista d'allotjaments als quals dona accés. */
    private ArrayList<Allotjament> allotjaments;

    /**
     * Constructor de la classe Acces.
     * @param nom Nom identificador de l'accés.
     * @param estat Estat inicial de l'accés (true=obert, false=tancat).
     */
    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.allotjaments = new ArrayList<>();
    }

    /**
     * Afegeix un allotjament a la llista d'allotjaments als quals dona accés.
     * @param allotjament L'allotjament a afegir.
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        allotjaments.add(allotjament);
    }

    /**
     * Tanca l'accés posant l'estat a false.
     */
    @Override
    public void tancarAcces() {
        estat = false;
    }

    /**
     * Obre l'accés posant l'estat a true.
     */
    @Override
    public void obrirAcces() {
        estat = true;
    }

    /**
     * Retorna el nom de l'accés.
     * @return Nom de l'accés.
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Retorna l'estat de l'accés.
     * @return true si està obert, false si està tancat.
     */
    @Override
    public boolean getEstat() {
        return estat;
    }

    /**
     * Modifica l'estat de l'accés.
     * @param estat Nou estat de l'accés (true=obert, false=tancat).
     */
    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    /**
     * Retorna una {@link LlistaAllotjaments} amb els allotjaments als quals dona accés.
     * @return LlistaAllotjaments amb els allotjaments associats.
     */
    @Override
    public LlistaAllotjaments getAAllotjaments() {
        LlistaAllotjaments llista = new LlistaAllotjaments();
        for (Allotjament a : allotjaments) {
            llista.afegirAllotjament(a);
        }
        return llista;
    }

    /**
     * Retorna una representació en String de l'accés.
     * @return String amb el nom i l'estat de l'accés.
     */
    @Override
    public String toString() {
        return "Acces{nom=" + nom + ", estat=" + estat + "}";
    }

    /**
     * Indica si l'accés proporciona accessibilitat amb vehicle.
     * Cada subclasse concreta ha d'implementar aquest mètode.
     * @return true si permet vehicle, false si no.
     */
    @Override
    public abstract boolean isAccessibilitat();
}