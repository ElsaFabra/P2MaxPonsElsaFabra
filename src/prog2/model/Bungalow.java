package prog2.model;

/** Definició de la subclasse de Casa que representa
 * els Bungalows. Té herència de Casa.
 * **/
public class Bungalow extends Casa{
    //Declaració dels atributs privats de Bungalow
    private int placesParquing; //Nombre de places de pàrquing que hi ha
    private boolean terrassa; // Boolean true si hi ha terrassa
    private boolean tv; // Boolean true si hi ha televisió
    private boolean aireFred; // Boolean true si hi ha sistema d'aire fred

    /** Constructor de la classe Bungalow, als paràmetres passen els
     * atributs de casa que s'inicialitzen fent ús del súper, i
     * després aprofito els setters per inicialitzar els altres
     * atributs de Bungalow. **/
    public Bungalow(String nom, String idAllotjament, boolean estatAllotjament, String estatIluminacio, float mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred){
        super(nom, idAllotjament, estatAllotjament, estatIluminacio, mida, habitacions, placesPersones, 7, 4);
        //Estada Minima en temporada alta de 7 dies i en estada minima en temporada baixa de 4 dies
        setPlacesParquing(placesParquing);
        setTerrassa(terrassa);
        setTv(tv);
        setAireFred(aireFred);
    }

    //Setters i getters per accedir als atributs privats
    public int getPlacesParquing() {
        return placesParquing;
    }

    public void setPlacesParquing(int placesParquing) {
        this.placesParquing = placesParquing;
    }

    public boolean isTerrassa() {
        return terrassa;
    }

    public void setTerrassa(boolean terrassa) {
        this.terrassa = terrassa;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isAireFred() {
        return aireFred;
    }

    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    //El mètode que determina si el Bungalow funciona correctament
    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    }
    //Retornarà true si funciona perquè només funciona si existeix sistema d'aire fred

    //Mètode toString que retorna amb un string totes les dades d'aquesta classe
    @Override
    public String toString(){
        return super.toString() + ". Bungalow(places de parquing = " + placesParquing +
                ", terrassa = " + terrassa + ", televisio = " + tv + ", aire fred = " + aireFred + ")";
    }

    @Override
    public void tancarAllotjament(TascaManteniment tasca) {

    }

    @Override
    public void obrirAllotjament() {

    }
}
