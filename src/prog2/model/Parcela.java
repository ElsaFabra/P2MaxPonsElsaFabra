package prog2.model;

import java.io.Serializable;

/**
 * Classe que representa una parcel·la del càmping.
 * Hereta de {@link Allotjament} i afegeix els atributs de mida i connexió elèctrica.
 * L'estada mínima és de 4 dies en temporada alta i 2 dies en temporada baixa.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class Parcela extends Allotjament implements Serializable {

    /** Mida de la parcel·la en metres quadrats. */
    private float mida;

    /** Indica si la parcel·la té connexió elèctrica. */
    private boolean connexioElectrica;

    /**
     * Constructor de la classe Parcela.
     * L'estada mínima és fixa: 4 dies en temporada alta i 2 en temporada baixa.
     * @param nom Nom de la parcel·la.
     * @param idAllotjament Identificador únic de la parcel·la.
     * @param estatAllotjament Estat operatiu inicial (true=operatiu).
     * @param estatIluminacio Percentatge d'il·luminació inicial.
     * @param mida Mida de la parcel·la en metres quadrats.
     * @param connexioElectrica true si té connexió elèctrica, false si no.
     */
    public Parcela(String nom, String idAllotjament, boolean estatAllotjament,
                   String estatIluminacio, float mida, boolean connexioElectrica) {
        super(nom, idAllotjament, estatAllotjament, estatIluminacio, 4, 2);
        setMida(mida);
        setConnexioElectrica(connexioElectrica);
    }

    /**
     * Retorna la mida de la parcel·la en metres quadrats.
     * @return Mida en metres quadrats.
     */
    public float getMida() { return mida; }

    /**
     * Modifica la mida de la parcel·la en metres quadrats.
     * @param metres Nova mida en metres quadrats.
     */
    public void setMida(float metres) { this.mida = metres; }

    /**
     * Retorna la mida de la parcel·la en metres quadrats.
     * @return Mida en metres quadrats.
     */
    public float getMetres() { return mida; }

    /**
     * Modifica la mida de la parcel·la en metres quadrats.
     * @param metres Nova mida en metres quadrats.
     */
    public void setMetres(float metres) { this.mida = metres; }

    /**
     * Retorna si la parcel·la té connexió elèctrica.
     * @return true si té connexió elèctrica, false si no.
     */
    public boolean isConnexioElectrica() { return connexioElectrica; }

    /**
     * Modifica si la parcel·la té connexió elèctrica.
     * @param connexioElectrica true si té connexió elèctrica, false si no.
     */
    public void setConnexioElectrica(boolean connexioElectrica) {
        this.connexioElectrica = connexioElectrica;
    }

    /**
     * Determina si la parcel·la funciona correctament.
     * La parcel·la funciona correctament si té connexió elèctrica.
     * @return true si té connexió elèctrica, false si no.
     */
    @Override
    public boolean correcteFuncionament() { return connexioElectrica; }

    /**
     * Retorna una representació en String de la parcel·la.
     * @return String amb la informació de la superclasse, mida i connexió elèctrica.
     */
    @Override
    public String toString() {
        return super.toString() + " Parcela{mida = " + mida +
                ", connexio electrica = " + connexioElectrica + "}";
    }
}