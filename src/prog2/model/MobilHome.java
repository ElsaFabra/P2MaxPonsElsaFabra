package prog2.model;

/**
 * Classe que representa un mobil-home del càmping.
 * Hereta de {@link Casa} i afegeix l'atribut de terrassa amb barbacoa.
 * L'estada mínima és de 3 dies en temporada alta i 5 dies en temporada baixa.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class MobilHome extends Casa {

    /** Indica si el mobil-home té terrassa amb barbacoa. */
    private boolean terrassaBarbacoa;

    /**
     * Constructor de la classe MobilHome.
     * L'estada mínima és fixa: 3 dies en temporada alta i 5 en temporada baixa.
     * @param nom Nom del mobil-home.
     * @param idAllotjament Identificador únic del mobil-home.
     * @param estatAllotjament Estat operatiu inicial (true=operatiu).
     * @param estatIluminacio Percentatge d'il·luminació inicial.
     * @param mida Mida del mobil-home en metres quadrats.
     * @param habitacions Nombre d'habitacions.
     * @param placesPersones Nombre màxim de persones.
     * @param terrassaBarbacoa true si té terrassa amb barbacoa, false si no.
     */
    public MobilHome(String nom, String idAllotjament, boolean estatAllotjament, String estatIluminacio,
                     float mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom, idAllotjament, estatAllotjament, estatIluminacio, mida, habitacions, placesPersones, 3, 5);
        setTerrassaBarbacoa(terrassaBarbacoa);
    }

    /**
     * Retorna si el mobil-home té terrassa amb barbacoa.
     * @return true si té terrassa amb barbacoa, false si no.
     */
    public boolean isTerrassaBarbacoa() { return terrassaBarbacoa; }

    /**
     * Modifica si el mobil-home té terrassa amb barbacoa.
     * @param terrassaBarbacoa true si té terrassa amb barbacoa, false si no.
     */
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) { this.terrassaBarbacoa = terrassaBarbacoa; }

    /**
     * Determina si el mobil-home funciona correctament.
     * El mobil-home funciona correctament si té terrassa amb barbacoa.
     * @return true si té terrassa amb barbacoa, false si no.
     */
    @Override
    public boolean correcteFuncionament() { return terrassaBarbacoa; }

    /**
     * Retorna una representació en String del mobil-home.
     * @return String amb la informació de la superclasse i els atributs del mobil-home.
     */
    @Override
    public String toString() {
        return super.toString() + ". Mobil-Home(Terrassa amb barbacoa = " + terrassaBarbacoa + ")";
    }
}