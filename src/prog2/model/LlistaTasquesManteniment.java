package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que gestiona una llista de tasques de manteniment del càmping.
 * Implementa la interfície {@link InLlistaTasquesManteniment}.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class LlistaTasquesManteniment implements InLlistaTasquesManteniment, Serializable {

    /** Llista interna de tasques de manteniment. */
    private ArrayList<TascaManteniment> tasques;

    /**
     * Constructor de la classe LlistaTasquesManteniment.
     * Inicialitza la llista buida.
     */
    public LlistaTasquesManteniment() {
        this.tasques = new ArrayList<>();
    }

    /**
     * Crea i afegeix una nova tasca de manteniment a la llista.
     * Tanca l'allotjament afectat i ajusta la seva il·luminació.
     * @param num Número identificador de la tasca.
     * @param tipus Tipus de tasca com a String.
     * @param allotjament Allotjament on s'ha de realitzar la tasca.
     * @param data Data de registre de la tasca.
     * @param dies Nombre de dies esperats per completar la tasca.
     * @throws ExcepcioCamping Si l'allotjament ja té una tasca activa o el tipus no existeix.
     */
    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament,
                                       String data, int dies) throws ExcepcioCamping {
        for (TascaManteniment t : tasques) {
            if (t.getAllotjament().getId().equals(allotjament.getId())) {
                throw new ExcepcioCamping("Ja existeix una tasca de manteniment per l'allotjament "
                        + allotjament.getNom());
            }
        }
        TascaManteniment.TipusTascaManteniment tipusEnum;
        try {
            tipusEnum = TascaManteniment.TipusTascaManteniment.valueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("El tipus de tasca " + tipus + " no existeix.");
        }
        TascaManteniment tasca = new TascaManteniment(num, tipusEnum, allotjament, data, dies);
        tasques.add(tasca);
        allotjament.tancarAllotjament(tasca);
    }

    /**
     * Completa i elimina una tasca de manteniment de la llista.
     * Obre l'allotjament afectat i restaura la il·luminació al 100%.
     * @param tasca Tasca de manteniment a completar.
     * @throws ExcepcioCamping Si la tasca no existeix a la llista.
     */
    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        if (!tasques.contains(tasca)) {
            throw new ExcepcioCamping("No existeix la tasca amb numero " + tasca.getNum());
        }
        tasca.getAllotjament().obrirAllotjament();
        tasques.remove(tasca);
    }

    /**
     * Retorna un String amb la informació de totes les tasques actives.
     * @return String amb la informació de totes les tasques.
     * @throws ExcepcioCamping Si no hi ha cap tasca activa.
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        if (tasques.isEmpty()) throw new ExcepcioCamping("No hi ha tasques de manteniment actives.");
        String result = "";
        for (TascaManteniment t : tasques) result += t.toString();
        return result;
    }

    /**
     * Busca i retorna la tasca amb el número indicat.
     * @param num Número identificador de la tasca a cercar.
     * @return Tasca de manteniment amb el número indicat.
     * @throws ExcepcioCamping Si no existeix cap tasca amb el número indicat.
     */
    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        for (TascaManteniment t : tasques) {
            if (t.getNum() == num) return t;
        }
        throw new ExcepcioCamping("No existeix cap tasca amb el numero " + num);
    }
}