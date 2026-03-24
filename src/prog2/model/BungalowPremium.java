package prog2.model;

/** Definició de la subclasse de Casa que representa
 * els Bungalows Premium. Té herència de Bungalow que té herència de Casa.
 * **/
public class BungalowPremium extends Bungalow{
    //Declaració dels atributs privats de Bungalow Premium
    private boolean serveisExtra_; //Boolean true si hi ha serveis extra
    private String codiWifi_; //Codi Wifi

    /** Constructor de la classe Bungalow Premium, als paràmetres passen els
     * atributs de casa que s'inicialitzen fent ús del super, i
     * després aprofito els setters per inicialitzar els altres
     * atributs de BungalowPremium **/
    public BungalowPremium(String nom_, String idAllotjament_,
                           String mida, int habitacions,
                           int placesPersones, int placesParquing,
                           boolean terrassa, boolean tv, boolean aireFred,
                           boolean serveisExtra, String codiWifi){
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        //No apareix l'estadaMinima perquè és la mateixa que la del Bungalow
        setServeisExtra_(serveisExtra);
        setCodiWifi_(codiWifi);
    }

    //Setters i getters per accedir als atributs privats
    public boolean isServeisExtra_() {
        return serveisExtra_;
    }

    public void setServeisExtra_(boolean serveisExtra_) {
        this.serveisExtra_ = serveisExtra_;
    }

    public String getCodiWifi_() {
        return codiWifi_;
    }

    public void setCodiWifi_(String codiWifi_) {
        this.codiWifi_ = codiWifi_;
    }

    //El mètode que determina si el Bungalow Premium funciona correctament
    @Override
    public boolean correcteFuncionament(){
        return isAireFred_() && codiWifi_ != null && codiWifi_.length() >= 8 && codiWifi_.length() <= 16;
        //Retornarà true (funcionarà) si hi ha aire fred i codi wifi, i si el codi wifi té entre 8 i 16 caràcters
    }

    //Mètode toString que retorna amb un string totes les dades d'aquesta classe
    @Override
    public String toString(){
        return super.toString() + ". Bungalow Premium(serveis extra = " + serveisExtra_ + ", codi wifi = " + codiWifi_ + ")";
    }
}
