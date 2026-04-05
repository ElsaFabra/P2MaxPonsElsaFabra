package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que gestiona una llista d'allotjaments del càmping.
 * Implementa la interfície {@link InLlistaAllotjaments}.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable {

    /** Llista interna d'allotjaments. */
    private ArrayList<Allotjament> allotjaments;

    /**
     * Constructor de la classe LlistaAllotjaments.
     * Inicialitza la llista buida.
     */
    public LlistaAllotjaments() {
        this.allotjaments = new ArrayList<>();
    }

    /**
     * Afegeix un allotjament a la llista. Llança excepció si ja existeix un amb el mateix id.
     * @param allotjament Allotjament a afegir.
     * @throws ExcepcioCamping Si ja existeix un allotjament amb el mateix identificador.
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        for (Allotjament a : allotjaments) {
            if (a.getId().equals(allotjament.getId())) {
                throw new ExcepcioCamping("Ja existeix aquest allotjament " + allotjament.getNom());
            }
        }
        allotjaments.add(allotjament);
    }

    /**
     * Buida la llista d'allotjaments.
     */
    @Override
    public void buidar() { allotjaments.clear(); }

    /**
     * Retorna un String amb la informació dels allotjaments amb l'estat indicat.
     * @param estat Estat a filtrar: "tots", "operatiu" o "no operatiu".
     * @return String amb la informació dels allotjaments filtrats.
     * @throws ExcepcioCamping Si la llista és buida o no hi ha allotjaments amb l'estat indicat.
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        if (allotjaments.isEmpty()) throw new ExcepcioCamping("No hi ha allotjaments.");
        String result = "";
        for (Allotjament a : allotjaments) {
            if (estat.equals("tots")) result += a.toString();
            else if (estat.equals("operatiu") && a.isOperatiu()) result += a.toString();
            else if (estat.equals("no operatiu") && !a.isOperatiu()) result += a.toString();
        }
        if (result.isEmpty()) throw new ExcepcioCamping("No hi ha allotjaments amb aquest estat.");
        return result;
    }

    /**
     * Comprova si la llista conté algun allotjament operatiu.
     * @return true si hi ha algun allotjament operatiu, false si no.
     */
    @Override
    public boolean containsAllotjamentOperatiu() {
        for (Allotjament a : allotjaments) {
            if (a.isOperatiu()) return true;
        }
        return false;
    }

    /**
     * Comprova si la llista conté l'allotjament indicat.
     * @param allotjament Allotjament a cercar.
     * @return true si l'allotjament és a la llista, false si no.
     */
    @Override
    public boolean contains(Allotjament allotjament) {
        for (Allotjament a : allotjaments) {
            if (a.getId().equals(allotjament.getId())) return true;
        }
        return false;
    }

    /**
     * Busca i retorna l'allotjament amb l'identificador indicat.
     * @param id Identificador de l'allotjament a cercar.
     * @return Allotjament amb l'identificador indicat.
     * @throws ExcepcioCamping Si no existeix cap allotjament amb l'identificador indicat.
     */
    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for (Allotjament a : allotjaments) {
            if (a.getId().equals(id)) return a;
        }
        throw new ExcepcioCamping("No existeix cap allotjament amb l'id " + id);
    }
}