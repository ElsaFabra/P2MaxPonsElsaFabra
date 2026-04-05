package prog2.model;

import java.io.Serializable;

/**
 * Classe abstracta que representa una casa del càmping.
 * Hereta de {@link Allotjament} i afegeix els atributs de mida, habitacions i places de persones.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public abstract class Casa extends Allotjament implements Serializable {

    /** Mida de la casa en metres quadrats. */
    private float mida;

    /** Nombre d'habitacions de la casa. */
    private int habitacions;

    /** Nombre màxim de persones que hi caben. */
    private int placesPersones;

    /**
     * Constructor de la classe Casa.
     * @param nom Nom de la casa.
     * @param idAllotjament Identificador únic de la casa.
     * @param estatAllotjament Estat operatiu inicial (true=operatiu).
     * @param estatIluminacio Percentatge d'il·luminació inicial.
     * @param mida Mida de la casa en metres quadrats.
     * @param habitacions Nombre d'habitacions.
     * @param placesPersones Nombre màxim de persones.
     * @param estadaMinimaALTA Estada mínima en temporada alta en dies.
     * @param estadaMinimaBAIXA Estada mínima en temporada baixa en dies.
     */
    public Casa(String nom, String idAllotjament, boolean estatAllotjament, String estatIluminacio,
                float mida, int habitacions, int placesPersones,
                long estadaMinimaALTA, long estadaMinimaBAIXA) {
        super(nom, idAllotjament, estatAllotjament, estatIluminacio, estadaMinimaALTA, estadaMinimaBAIXA);
        setMida(mida);
        setHabitacions(habitacions);
        setPlacesPersones(placesPersones);
    }

    /**
     * Retorna la mida de la casa en metres quadrats.
     * @return Mida en metres quadrats.
     */
    public float getMida() { return mida; }

    /**
     * Modifica la mida de la casa en metres quadrats.
     * @param mida Nova mida en metres quadrats.
     */
    public void setMida(float mida) { this.mida = mida; }

    /**
     * Retorna el nombre d'habitacions de la casa.
     * @return Nombre d'habitacions.
     */
    public int getHabitacions() { return habitacions; }

    /**
     * Modifica el nombre d'habitacions de la casa.
     * @param habitacions Nou nombre d'habitacions.
     */
    public void setHabitacions(int habitacions) { this.habitacions = habitacions; }

    /**
     * Retorna el nombre màxim de persones que hi caben.
     * @return Nombre màxim de persones.
     */
    public int getPlacesPersones() { return placesPersones; }

    /**
     * Modifica el nombre màxim de persones que hi caben.
     * @param placesPersones Nou nombre màxim de persones.
     */
    public void setPlacesPersones(int placesPersones) { this.placesPersones = placesPersones; }

    /**
     * Retorna una representació en String de la casa.
     * @return String amb la informació de la superclasse, mida, habitacions i places.
     */
    @Override
    public String toString() {
        return super.toString() + " Mida = " + mida +
                ", habitacions = " + habitacions +
                ", places de persones = " + placesPersones;
    }
}