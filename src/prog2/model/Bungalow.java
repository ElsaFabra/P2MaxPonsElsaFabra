package prog2.model;

/**
 * Classe que representa un bungalow del càmping.
 * Hereta de {@link Casa} i afegeix places de pàrquing, terrassa, televisió i aire fred.
 * L'estada mínima és de 7 dies en temporada alta i 4 dies en temporada baixa.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class Bungalow extends Casa {

    /** Nombre de places de pàrquing del bungalow. */
    private int placesParquing;

    /** Indica si el bungalow té terrassa. */
    private boolean terrassa;

    /** Indica si el bungalow té televisió. */
    private boolean tv;

    /** Indica si el bungalow té sistema d'aire fred. */
    private boolean aireFred;

    /**
     * Constructor de la classe Bungalow.
     * L'estada mínima és fixa: 7 dies en temporada alta i 4 en temporada baixa.
     * @param nom Nom del bungalow.
     * @param idAllotjament Identificador únic del bungalow.
     * @param estatAllotjament Estat operatiu inicial (true=operatiu).
     * @param estatIluminacio Percentatge d'il·luminació inicial.
     * @param mida Mida del bungalow en metres quadrats.
     * @param habitacions Nombre d'habitacions.
     * @param placesPersones Nombre màxim de persones.
     * @param placesParquing Nombre de places de pàrquing.
     * @param terrassa true si té terrassa, false si no.
     * @param tv true si té televisió, false si no.
     * @param aireFred true si té sistema d'aire fred, false si no.
     */
    public Bungalow(String nom, String idAllotjament, boolean estatAllotjament, String estatIluminacio,
                    float mida, int habitacions, int placesPersones, int placesParquing,
                    boolean terrassa, boolean tv, boolean aireFred) {
        super(nom, idAllotjament, estatAllotjament, estatIluminacio, mida, habitacions, placesPersones, 7, 4);
        setPlacesParquing(placesParquing);
        setTerrassa(terrassa);
        setTv(tv);
        setAireFred(aireFred);
    }

    /**
     * Retorna el nombre de places de pàrquing.
     * @return Nombre de places de pàrquing.
     */
    public int getPlacesParquing() { return placesParquing; }

    /**
     * Modifica el nombre de places de pàrquing.
     * @param placesParquing Nou nombre de places de pàrquing.
     */
    public void setPlacesParquing(int placesParquing) { this.placesParquing = placesParquing; }

    /**
     * Retorna si el bungalow té terrassa.
     * @return true si té terrassa, false si no.
     */
    public boolean isTerrassa() { return terrassa; }

    /**
     * Modifica si el bungalow té terrassa.
     * @param terrassa true si té terrassa, false si no.
     */
    public void setTerrassa(boolean terrassa) { this.terrassa = terrassa; }

    /**
     * Retorna si el bungalow té televisió.
     * @return true si té televisió, false si no.
     */
    public boolean isTv() { return tv; }

    /**
     * Modifica si el bungalow té televisió.
     * @param tv true si té televisió, false si no.
     */
    public void setTv(boolean tv) { this.tv = tv; }

    /**
     * Retorna si el bungalow té sistema d'aire fred.
     * @return true si té aire fred, false si no.
     */
    public boolean isAireFred() { return aireFred; }

    /**
     * Modifica si el bungalow té sistema d'aire fred.
     * @param aireFred true si té aire fred, false si no.
     */
    public void setAireFred(boolean aireFred) { this.aireFred = aireFred; }

    /**
     * Determina si el bungalow funciona correctament.
     * El bungalow funciona correctament si té sistema d'aire fred.
     * @return true si té aire fred, false si no.
     */
    @Override
    public boolean correcteFuncionament() { return aireFred; }

    /**
     * Retorna una representació en String del bungalow.
     * @return String amb la informació de la superclasse i els atributs del bungalow.
     */
    @Override
    public String toString() {
        return super.toString() + ". Bungalow{places de parquing = " + placesParquing +
                ", terrassa = " + terrassa + ", televisio = " + tv +
                ", aire fred = " + aireFred + "}";
    }
}