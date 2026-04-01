package prog2.model;

import java.io.Serializable;

/** Definició de la subclasse d'Allotjament que representa
 * la Casa. Té herència d'Allotjament.
 * **/
public abstract class Casa extends Allotjament implements Serializable {
    //Declaració dels atributs privats de Casa
    private String mida; //Mida de la casa
    private int habitacions; //Nombre d'habitacions
    private int placesPersones; //Quantitat de persones que caben

    /** Constructor de la classe Casa, als paràmetres passen els
     * atributs d'Allotjament que s'inicialitzen fent ús del super, i
     * després aprofito els setters per inicialitzar els altres
     * atributs de Casa **/
    public Casa(String nom, String idAllotjament, boolean estatAllotjament, String estatIluminacio, String mida, int habitacions, int placesPersones, long estadaMinimaALTA, long estadaMinimaBAIXA) {
        super(nom, idAllotjament, estatAllotjament, estatIluminacio, estadaMinimaALTA, estadaMinimaBAIXA);
        //Com cada tipus de casa té estades minimes diferents, aquí no l'inicialitzo amb cao valor
        setMida(mida);
        setHabitacions(habitacions);
        setPlacesPersones(placesPersones);

    }

    //Setters i getters per accedir als atributs privats
    public String getMida() { return mida; }

    public void setMida(String mida) { this.mida = mida; }

    public int getHabitacions() { return habitacions; }

    public void setHabitacions(int habitacions) { this.habitacions = habitacions;}

    public int getPlacesPersones() { return placesPersones;}

    public void setPlacesPersones(int placesPersones) { this.placesPersones = placesPersones;}

    //Mètode toString que retorna amb un string totes les dades d'aquesta classe
    @Override
    public String toString() {
        return super.toString() + " Mida = " + mida + ", habitacions = " + habitacions + ", places de persones = " + placesPersones;
    }
}
