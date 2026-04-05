package prog2.model;

import java.io.Serializable;

/**
 * Classe que representa un camí de terra.
 * Hereta de {@link AccesTerra} i no proporciona accessibilitat amb vehicle.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class CamiTerra extends AccesTerra implements Serializable {

    /**
     * Constructor de la classe CamiTerra.
     * @param nom Nom identificador de l'accés.
     * @param estat Estat inicial de l'accés (true=obert, false=tancat).
     * @param longitud Longitud del camí en metres.
     */
    public CamiTerra(String nom, boolean estat, double longitud) {
        super(nom, estat, longitud);
    }

    /**
     * Indica que el camí de terra no proporciona accessibilitat amb vehicle.
     * @return false sempre.
     */
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    /**
     * Retorna una representació en String del camí de terra.
     * @return String amb la informació del camí de terra.
     */
    @Override
    public String toString() {
        return "CamiTerra{" + super.toString() + "}";
    }
}