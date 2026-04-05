package prog2.model;

/**
 * Classe que representa un bungalow premium del càmping.
 * Hereta de {@link Bungalow} i afegeix serveis extra i codi Wifi.
 * El codi Wifi ha de tenir entre 8 i 16 caràcters per funcionar correctament.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class BungalowPremium extends Bungalow {

    /** Indica si el bungalow premium té serveis extra (llençols i tovalloles). */
    private boolean serveisExtra;

    /** Codi Wifi del bungalow premium. Ha de tenir entre 8 i 16 caràcters. */
    private String codiWifi;

    /**
     * Constructor de la classe BungalowPremium.
     * @param nom Nom del bungalow premium.
     * @param idAllotjament Identificador únic del bungalow premium.
     * @param estatAllotjament Estat operatiu inicial (true=operatiu).
     * @param estatIluminacio Percentatge d'il·luminació inicial.
     * @param mida Mida del bungalow en metres quadrats.
     * @param habitacions Nombre d'habitacions.
     * @param placesPersones Nombre màxim de persones.
     * @param placesParquing Nombre de places de pàrquing.
     * @param terrassa true si té terrassa, false si no.
     * @param tv true si té televisió, false si no.
     * @param aireFred true si té sistema d'aire fred, false si no.
     * @param serveisExtra true si té serveis extra, false si no.
     * @param codiWifi Codi Wifi del bungalow premium.
     */
    public BungalowPremium(String nom, String idAllotjament, boolean estatAllotjament,
                           String estatIluminacio, float mida, int habitacions, int placesPersones,
                           int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                           boolean serveisExtra, String codiWifi) {
        super(nom, idAllotjament, estatAllotjament, estatIluminacio, mida, habitacions,
                placesPersones, placesParquing, terrassa, tv, aireFred);
        setServeisExtra(serveisExtra);
        setCodiWifi(codiWifi);
    }

    /**
     * Retorna si el bungalow premium té serveis extra.
     * @return true si té serveis extra, false si no.
     */
    public boolean isServeisExtra() { return serveisExtra; }

    /**
     * Modifica si el bungalow premium té serveis extra.
     * @param serveisExtra true si té serveis extra, false si no.
     */
    public void setServeisExtra(boolean serveisExtra) { this.serveisExtra = serveisExtra; }

    /**
     * Retorna el codi Wifi del bungalow premium.
     * @return Codi Wifi.
     */
    public String getCodiWifi() { return codiWifi; }

    /**
     * Modifica el codi Wifi del bungalow premium.
     * @param codiWifi Nou codi Wifi.
     */
    public void setCodiWifi(String codiWifi) { this.codiWifi = codiWifi; }

    /**
     * Determina si el bungalow premium funciona correctament.
     * Funciona correctament si té aire fred i el codi Wifi té entre 8 i 16 caràcters.
     * @return true si funciona correctament, false si no.
     */
    @Override
    public boolean correcteFuncionament() {
        return isAireFred() && codiWifi != null &&
                codiWifi.length() >= 8 && codiWifi.length() <= 16;
    }

    /**
     * Retorna una representació en String del bungalow premium.
     * @return String amb la informació de la superclasse i els atributs del bungalow premium.
     */
    @Override
    public String toString() {
        return super.toString() + ". Bungalow Premium(serveis extra = " +
                serveisExtra + ", codi wifi = " + codiWifi + ")";
    }
}