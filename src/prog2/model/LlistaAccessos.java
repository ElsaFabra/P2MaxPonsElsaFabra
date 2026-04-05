package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que gestiona una llista d'accessos del càmping.
 * Implementa la interfície {@link InLlistaAccessos}.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class LlistaAccessos implements InLlistaAccessos, Serializable {

    /** Llista interna d'accessos. */
    private ArrayList<Acces> accessos;

    /**
     * Constructor de la classe LlistaAccessos.
     * Inicialitza la llista buida.
     */
    public LlistaAccessos() {
        this.accessos = new ArrayList<>();
    }

    /**
     * Afegeix un accés a la llista. Llança excepció si ja existeix un amb el mateix nom.
     * @param acc Accés a afegir.
     * @throws ExcepcioCamping Si ja existeix un accés amb el mateix nom.
     */
    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        for (Acces a : accessos) {
            if (a.getNom().equals(acc.getNom())) {
                throw new ExcepcioCamping("Ja existeix un acces amb el nom " + acc.getNom());
            }
        }
        accessos.add(acc);
    }

    /**
     * Buida la llista d'accessos.
     */
    @Override
    public void buidar() { accessos.clear(); }

    /**
     * Retorna un String amb la informació dels accessos amb l'estat indicat.
     * @param estat true per llistar els oberts, false per llistar els tancats.
     * @return String amb la informació dels accessos filtrats.
     * @throws ExcepcioCamping Si no hi ha accessos amb l'estat indicat.
     */
    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        String resultat = "";
        for (Acces acc : accessos) {
            if (acc.getEstat() == estat) resultat += acc.toString() + "\n";
        }
        if (resultat.isEmpty()) throw new ExcepcioCamping("No hi ha accessos amb aquest estat");
        return resultat;
    }

    /**
     * Actualitza l'estat de tots els accessos en funció dels allotjaments als quals donen accés.
     * Un accés es tanca si cap dels seus allotjaments és operatiu.
     * @throws ExcepcioCamping Si es produeix un error durant l'actualització.
     */
    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for (Acces acces : accessos) {
            acces.setEstat(acces.getAAllotjaments().containsAllotjamentOperatiu());
        }
    }

    /**
     * Calcula el nombre d'accessos que no proporcionen accessibilitat amb vehicle.
     * @return Nombre d'accessos no accessibles amb vehicle.
     * @throws ExcepcioCamping Si es produeix un error durant el càlcul.
     */
    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        int accNo = 0;
        for (Acces acc : accessos) {
            if (!acc.isAccessibilitat()) accNo++;
        }
        return accNo;
    }

    /**
     * Calcula la suma total de metres de longitud dels accessos de terra.
     * @return Total de metres dels accessos de terra.
     * @throws ExcepcioCamping Si es produeix un error durant el càlcul.
     */
    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        float metres = 0;
        for (Acces acc : accessos) {
            if (acc instanceof AccesTerra) metres += (float) ((AccesTerra) acc).getLongitud();
        }
        return metres;
    }
}