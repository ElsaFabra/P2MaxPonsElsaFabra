package prog2.model;

/** Definició de la subclasse de Casa que representa
 * els Glampings. Té herència de Casa.
 * **/
public class Glamping extends Casa{
    //Declaració dels atributs privats de Glamping
    private String material_; //Tipus de material
    private boolean casaMascota_; //Boolean true si hi ha casa de mascotes

    /** Constructor de la classe Glamping, als paràmetres passen els
     * atributs de casa que s'inicialitzen fent ús del super, i
     * després aprofito els setters per inicialitzar els altres
     * atributs de Glamping **/
    public Glamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota){
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 3, 3);
        //Estada Minima en temporada alta de 3 dies i en estada minima en temporada baixa de 3 dies
        setMaterial_(material);
        setCasaMascota_(casaMascota);
    }

    //Setters i getters per accedir als atributs privats
    public String getMaterial_() { return material_;}

    public void setMaterial_(String material) {this.material_ = material;}

    public boolean isCasaMascota_() {return casaMascota_;}

    public void setCasaMascota_(boolean casaMascota) {this.casaMascota_ = casaMascota;}

    //El mètode que determina si el Glamping funciona correctament
    @Override
    public boolean correcteFuncionament() {
        return casaMascota_;
        //Retornarà true si funciona perquè només funciona si existeix casa de mascotes
    }

    //Mètode toString que retorna amb un string totes les dades d'aquesta classe
    @Override
    public String toString(){
        return super.toString() + ". Glamping(material = " + material_ + ", casa de mascotes = " + casaMascota_ + ")";
    }
}
