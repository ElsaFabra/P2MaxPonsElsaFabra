package prog2.model;

import java.io.Serializable;

/**
 * Classe que representa una carretera de terra.
 * Hereta de {@link AccesTerra} i proporciona accessibilitat amb vehicle.
 * Afegeix l'atribut d'amplada de la carretera.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class CarreteraTerra extends AccesTerra implements Serializable {

    /** Amplada de la carretera en metres. */
    private double amplada;

    /**
     * Constructor de la classe CarreteraTerra.
     * @param nom Nom identificador de l'accés.
     * @param estat Estat inicial de l'accés (true=obert, false=tancat).
     * @param longitud Longitud de la carretera en metres.
     * @param amplada Amplada de la carretera en metres.
     */
    public CarreteraTerra(String nom, boolean estat, double longitud, double amplada) {
        super(nom, estat, longitud);
        this.amplada = amplada;
    }

    /**
     * Retorna l'amplada de la carretera en metres.
     * @return Amplada en metres.
     */
    public double getAmplada() {
        return amplada;
    }

    /**
     * Modifica l'amplada de la carretera en metres.
     * @param amplada Nova amplada en metres.
     */
    public void setAmplada(double amplada) {
        this.amplada = amplada;
    }

    /**
     * Indica que la carretera de terra proporciona accessibilitat amb vehicle.
     * @return true sempre.
     */
    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    /**
     * Retorna una representació en String de la carretera de terra.
     * @return String amb la informació de la carretera de terra i l'amplada.
     */
    @Override
    public String toString() {
        return "CarreteraTerra{" + super.toString() + ", amplada=" + amplada + "}";
    }
}


