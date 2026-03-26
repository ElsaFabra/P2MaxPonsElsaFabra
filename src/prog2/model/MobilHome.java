package prog2.model;

/** Definició de la subclasse de Casa que representa
 * els Mobil-Home. Té herència de Casa.
 * **/
public class MobilHome extends Casa{
    private boolean terrassaBarbacoa; //Boolean true si ha terrassa amb barbacoa

    /** Constructor de la classe Glamping, als paràmetres passen els
     * atributs de Casa que s'inicialitzen fent ús del super, i
     * després aprofito els setters per inicialitzar els altres
     * atributs de MobilHome **/
    public MobilHome(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom, idAllotjament, mida, habitacions, placesPersones, 3, 5, true, "100%");
        //Estada Minima en temporada alta de 3 dies i en estada minima en temporada baixa de 5 dies
        setTerrassaBarbacoa(terrassaBarbacoa);
    }

    //Setters i getters per accedir als atributs privats
    public boolean isTerrassaBarbacoa() { return terrassaBarbacoa;}

    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) { this.terrassaBarbacoa = terrassaBarbacoa;}

    //El mètode que determina si el MobilHome funciona correctament
    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
        //Retornarà true si funciona perquè només funciona si existeix terrassa amb barbacoa
    }

    //Mètode toString que retorna amb un string totes les dades d'aquesta classe
    @Override
    public String toString() {
        return super.toString() + ". Mobil-Home(Terrassa amb barbacoa = " + terrassaBarbacoa + ")";
    }

    @Override
    public void tancarAllotjament(TascaManteniment tasca) {
    }

    @Override
    public void obrirAllotjament() {
    }
}
