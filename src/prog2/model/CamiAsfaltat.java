package prog2.model;

import java.io.Serializable;

/**
 * Classe que representa un camí asfaltat.
 * Hereta de {@link AccesAsfalt} i no proporciona accessibilitat amb vehicle.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class CamiAsfaltat extends AccesAsfalt implements Serializable {

    /**
     * Constructor de la classe CamiAsfaltat.
     * @param nom Nom identificador de l'accés.
     * @param estat Estat inicial de l'accés (true=obert, false=tancat).
     * @param metresQuadrats Metres quadrats d'asfalt del camí.
     */
    public CamiAsfaltat(String nom, boolean estat, double metresQuadrats) {
        super(nom, estat, metresQuadrats);
    }

    /**
     * Indica que el camí asfaltat no proporciona accessibilitat amb vehicle.
     * @return false sempre.
     */
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    /**
     * Retorna una representació en String del camí asfaltat.
     * @return String amb la informació del camí asfaltat.
     */
    @Override
    public String toString() {
        return "CamiAsfalt{" + super.toString() + "}";
    }
}
