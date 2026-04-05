package prog2.model;

import java.io.Serializable;

/**
 * Classe que representa una tasca de manteniment d'un allotjament del càmping.
 * Conté el número identificador, el tipus de tasca, l'allotjament afectat, la data i els dies esperats.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class TascaManteniment implements InTascaManteniment, Serializable {

    /**
     * Enumeració amb els tipus possibles de tasca de manteniment.
     * Cada tipus determina un percentatge d'il·luminació diferent per a l'allotjament.
     */
    public static enum TipusTascaManteniment {
        /** Reparació d'algun aspecte de l'allotjament. Il·luminació al 50%. */
        Reparacio,
        /** Neteja de l'allotjament. Il·luminació al 100%. */
        Neteja,
        /** Revisió tècnica d'algun element de l'allotjament. Il·luminació al 50%. */
        RevisioTecnica,
        /** Desinfecció de l'allotjament. Il·luminació al 0%. */
        Desinfeccio
    }

    /** Número identificador únic de la tasca. */
    private int num;

    /** Allotjament on s'ha de realitzar la tasca. */
    private Allotjament allotjament;

    /** Data en què s'ha registrat la tasca. */
    private String data;

    /** Tipus de tasca de manteniment. */
    private TipusTascaManteniment tipus;

    /** Nombre de dies esperats per completar la tasca. */
    private int dies;

    /**
     * Constructor de la classe TascaManteniment.
     * @param num Número identificador únic de la tasca.
     * @param tipus Tipus de tasca de manteniment.
     * @param allotjament Allotjament on s'ha de realitzar la tasca.
     * @param data Data en què s'ha registrat la tasca.
     * @param dies Nombre de dies esperats per completar la tasca.
     */
    public TascaManteniment(int num, TipusTascaManteniment tipus, Allotjament allotjament,
                            String data, int dies) {
        this.num = num;
        this.allotjament = allotjament;
        this.data = data;
        this.tipus = tipus;
        this.dies = dies;
    }

    /**
     * Retorna el número identificador de la tasca.
     * @return Número identificador.
     */
    @Override
    public int getNum() { return num; }

    /**
     * Retorna el tipus de tasca de manteniment.
     * @return Tipus de tasca.
     */
    @Override
    public TipusTascaManteniment getTipus() { return tipus; }

    /**
     * Retorna l'allotjament associat a la tasca.
     * @return Allotjament afectat.
     */
    @Override
    public Allotjament getAllotjament() { return allotjament; }

    /**
     * Retorna la data de registre de la tasca.
     * @return Data de la tasca.
     */
    @Override
    public String getData() { return data; }

    /**
     * Retorna el nombre de dies previstos per completar la tasca.
     * @return Nombre de dies.
     */
    @Override
    public int getDies() { return dies; }

    /**
     * Modifica el número identificador de la tasca.
     * @param num Nou número identificador.
     */
    @Override
    public void setNum(int num) { this.num = num; }

    /**
     * Modifica el tipus de tasca de manteniment.
     * @param tipus Nou tipus de tasca.
     */
    @Override
    public void setTipus(TipusTascaManteniment tipus) { this.tipus = tipus; }

    /**
     * Modifica l'allotjament associat a la tasca.
     * @param allotjament Nou allotjament afectat.
     */
    @Override
    public void setAllotjament(Allotjament allotjament) { this.allotjament = allotjament; }

    /**
     * Modifica la data de registre de la tasca.
     * @param data Nova data de la tasca.
     */
    @Override
    public void setData(String data) { this.data = data; }

    /**
     * Modifica el nombre de dies previstos per completar la tasca.
     * @param dies Nou nombre de dies.
     */
    @Override
    public void setDies(int dies) { this.dies = dies; }

    /**
     * Retorna el percentatge d'il·luminació que ha de tenir l'allotjament segons el tipus de tasca.
     * Reparacio i RevisioTecnica retornen "50%", Neteja retorna "100%", Desinfeccio retorna "0%".
     * @return Percentatge d'il·luminació com a String.
     */
    @Override
    public String getIluminacioAllotjament() {
        switch (tipus) {
            case Reparacio, RevisioTecnica: return "50%";
            case Neteja: return "100%";
            case Desinfeccio: return "0%";
            default: return "0%";
        }
    }

    /**
     * Retorna una representació en String de la tasca de manteniment.
     * @return String amb el número, allotjament, data, tipus, dies i il·luminació de la tasca.
     */
    @Override
    public String toString() {
        return "TascaManteniment{" +
                "numTasca=" + num +
                ", allotjament=" + allotjament.getNom() +
                ", data=" + data +
                ", tipus=" + tipus +
                ", dies=" + dies +
                ", iluminacio=" + getIluminacioAllotjament() + '}';
    }
}