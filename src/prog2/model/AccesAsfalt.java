package prog2.model;

import java.io.Serializable;

/**
 * Classe abstracta que representa un accés de tipus asfaltat.
 * Hereta de {@link Acces} i afegeix l'atribut de metres quadrats d'asfalt.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public abstract class AccesAsfalt extends Acces implements Serializable {

    /** Metres quadrats d'asfalt de l'accés. */
    private double metresQuadrats;

    /**
     * Constructor de la classe AccesAsfalt.
     * @param nom Nom identificador de l'accés.
     * @param estat Estat inicial de l'accés (true=obert, false=tancat).
     * @param metresQuadrats Metres quadrats d'asfalt de l'accés.
     */
    public AccesAsfalt(String nom, boolean estat, double metresQuadrats) {
        super(nom, estat);
        this.metresQuadrats = metresQuadrats;
    }

    /**
     * Retorna els metres quadrats d'asfalt de l'accés.
     * @return Metres quadrats d'asfalt.
     */
    public double getMetresQuadrats() {
        return metresQuadrats;
    }

    /**
     * Modifica els metres quadrats d'asfalt de l'accés.
     * @param metresQuadrats Nous metres quadrats d'asfalt.
     */
    public void setMetresQuadrats(double metresQuadrats) {
        this.metresQuadrats = metresQuadrats;
    }

    /**
     * Retorna una representació en String de l'accés asfaltat.
     * @return String amb la informació de la superclasse i els metres quadrats.
     */
    @Override
    public String toString() {
        return super.toString() + ", metresQuadrats=" + metresQuadrats;
    }
}