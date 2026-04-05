package prog2.model;

import java.io.Serializable;

/**
 * Classe que representa una carretera asfaltada.
 * Hereta de {@link AccesAsfalt} i proporciona accessibilitat amb vehicle.
 * Afegeix l'atribut de pes màxim dels vehicles que hi poden passar.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class CarreteraAsfaltada extends AccesAsfalt implements Serializable {

    /** Pes màxim en kg dels vehicles que poden passar per la carretera. */
    private double pesMaxim;

    /**
     * Constructor de la classe CarreteraAsfaltada.
     * @param nom Nom identificador de l'accés.
     * @param estat Estat inicial de l'accés (true=obert, false=tancat).
     * @param metresQuadrats Metres quadrats d'asfalt de la carretera.
     * @param pesMaxim Pes màxim en kg dels vehicles que hi poden passar.
     */
    public CarreteraAsfaltada(String nom, boolean estat, double metresQuadrats, double pesMaxim) {
        super(nom, estat, metresQuadrats);
        this.pesMaxim = pesMaxim;
    }

    /**
     * Retorna el pes màxim dels vehicles que poden passar per la carretera.
     * @return Pes màxim en kg.
     */
    public double getPesMaxim() {
        return pesMaxim;
    }

    /**
     * Modifica el pes màxim dels vehicles que poden passar per la carretera.
     * @param pesMaxim Nou pes màxim en kg.
     */
    public void setMaximPes(double pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    /**
     * Indica que la carretera asfaltada proporciona accessibilitat amb vehicle.
     * @return true sempre.
     */
    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    /**
     * Retorna una representació en String de la carretera asfaltada.
     * @return String amb la informació de la carretera asfaltada i el pes màxim.
     */
    @Override
    public String toString() {
        return "CarreteraAsfalt{" + super.toString() + ", pesMaxim=" + pesMaxim + "}";
    }
}
