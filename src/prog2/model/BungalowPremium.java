package prog2.model;

/** Definició de la subclasse de Casa que representa
 * els Bungalows Premium. Té herència de Bungalow que té herència de Casa.
 * **/
public class BungalowPremium extends Bungalow{
    //Declaració dels atributs privats de Bungalow Premium
    private boolean serveisExtra; //Boolean true si hi ha serveis extra
    private String codiWifi; //Codi Wifi

    /** Constructor de la classe Bungalow Premium, als paràmetres passen els
     * atributs de casa que s'inicialitzen fent ús del super, i
     * després aprofito els setters per inicialitzar els altres
     * atributs de BungalowPremium **/
    public BungalowPremium(String nom, String idAllotjament,
                           String mida, int habitacions,
                           int placesPersones, int placesParquing,
                           boolean terrassa, boolean tv, boolean aireFred,
                           boolean serveisExtra, String codiWifi){
        super(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        //No apareix l'estadaMinima perquè és la mateixa que la del Bungalow
        setServeisExtra(serveisExtra);
        setCodiWifi(codiWifi);
    }

    //Setters i getters per accedir als atributs privats
    public boolean isServeisExtra() {
        return serveisExtra;
    }

    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra = serveisExtra;
    }

    public String getCodiWifi() {
        return codiWifi;
    }

    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }

    //El mètode que determina si el Bungalow Premium funciona correctament
    @Override
    public boolean correcteFuncionament(){
        return isAireFred() && codiWifi != null && codiWifi.length() >= 8 && codiWifi.length() <= 16;
        //Retornarà true (funcionarà) si hi ha aire fred i codi wifi, i si el codi wifi té entre 8 i 16 caràcters
    }

    //Mètode toString que retorna amb un string totes les dades d'aquesta classe
    @Override
    public String toString(){
        return super.toString() + ". Bungalow Premium(serveis extra = " + serveisExtra + ", codi wifi = " + codiWifi + ")";
    }
}
