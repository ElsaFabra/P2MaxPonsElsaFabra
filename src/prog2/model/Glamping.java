package prog2.model;

/**
 * Classe que representa un glamping del càmping.
 * Hereta de {@link Casa} i afegeix els atributs de material i casa de mascotes.
 * L'estada mínima és de 3 dies tant en temporada alta com en temporada baixa.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class Glamping extends Casa {

    /** Material de construcció del glamping. */
    private String material;

    /** Indica si el glamping té casa de mascotes. */
    private boolean casaMascota;

    /**
     * Constructor de la classe Glamping.
     * L'estada mínima és fixa: 3 dies tant en temporada alta com en temporada baixa.
     * @param nom Nom del glamping.
     * @param idAllotjament Identificador únic del glamping.
     * @param estatAllotjament Estat operatiu inicial (true=operatiu).
     * @param estatIluminacio Percentatge d'il·luminació inicial.
     * @param mida Mida del glamping en metres quadrats.
     * @param habitacions Nombre d'habitacions.
     * @param placesPersones Nombre màxim de persones.
     * @param material Material de construcció del glamping.
     * @param casaMascota true si té casa de mascotes, false si no.
     */
    public Glamping(String nom, String idAllotjament, boolean estatAllotjament, String estatIluminacio,
                    float mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        super(nom, idAllotjament, estatAllotjament, estatIluminacio, mida, habitacions, placesPersones, 3, 3);
        setMaterial_(material);
        setCasaMascota_(casaMascota);
    }

    /**
     * Retorna el material de construcció del glamping.
     * @return Material de construcció.
     */
    public String getMaterial_() { return material; }

    /**
     * Modifica el material de construcció del glamping.
     * @param material Nou material de construcció.
     */
    public void setMaterial_(String material) { this.material = material; }

    /**
     * Retorna si el glamping té casa de mascotes.
     * @return true si té casa de mascotes, false si no.
     */
    public boolean isCasaMascota_() { return casaMascota; }

    /**
     * Modifica si el glamping té casa de mascotes.
     * @param casaMascota true si té casa de mascotes, false si no.
     */
    public void setCasaMascota_(boolean casaMascota) { this.casaMascota = casaMascota; }

    /**
     * Determina si el glamping funciona correctament.
     * El glamping funciona correctament si té casa de mascotes.
     * @return true si té casa de mascotes, false si no.
     */
    @Override
    public boolean correcteFuncionament() { return casaMascota; }

    /**
     * Retorna una representació en String del glamping.
     * @return String amb la informació de la superclasse i els atributs del glamping.
     */
    @Override
    public String toString() {
        return super.toString() + ". Glamping(material = " + material +
                ", casa de mascotes = " + casaMascota + ")";
    }
}