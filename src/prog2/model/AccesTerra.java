package prog2.model;

/**
 * Classe abstracta que representa un accés de tipus terra.
 * Hereta de {@link Acces} i afegeix l'atribut de longitud en metres.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public abstract class AccesTerra extends Acces {

    /** Longitud de l'accés en metres. */
    private double longitud;

    /**
     * Constructor de la classe AccesTerra.
     * @param nom Nom identificador de l'accés.
     * @param estat Estat inicial de l'accés (true=obert, false=tancat).
     * @param longitud Longitud de l'accés en metres.
     */
    public AccesTerra(String nom, boolean estat, double longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    /**
     * Retorna la longitud de l'accés en metres.
     * @return Longitud en metres.
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * Modifica la longitud de l'accés en metres.
     * @param longitud Nova longitud en metres.
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    /**
     * Retorna una representació en String de l'accés de terra.
     * @return String amb la informació de la superclasse i la longitud.
     */
    @Override
    public String toString() {
        return super.toString() + ". longitud=" + longitud;
    }
}