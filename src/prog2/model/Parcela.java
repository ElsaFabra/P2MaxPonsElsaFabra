package prog2.model;

/** Definició de la subclasse d'Allotjament que representa la Parcela.
 * Obté herència d'allotjament.
 * **/

public class Parcela extends Allotjament {
    //Declaració dels atributs privats de Parcela
    private float mida_; //Mida de la parcela
    private boolean connexioElectrica_; //Boolean true si hi ha connexió elèctrica

    /** Constructor de la classe Parcela, als paràmetres passen els
     * atributs d'Allotjament que s'inicialitzen fent ús del super, i
     * després aprofito els setters per inicialitzar els altres
     * atributs de Parcela **/
    public Parcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        super(nom_, idAllotjament_, 4, 2);
        //Estada Minima en temporada alta de 4 dies i en estada minima en temporada baixa de 2 dies
        setMida(metres);
        setConnexioElectrica(connexioElectrica);
    }

    //Setters i getters per accedir als atributs privats
    public float getMida() {
        return mida_;
    }

    public void setMida(float metres) {
        this.mida_ = metres;
    }

    public float getMetres() {
        return mida_;
    }

    public void setMetres(float metres) {
        this.mida_ = metres;
    }

    public boolean isConnexioElectrica() {
        return connexioElectrica_;
    }

    public void setConnexioElectrica(boolean connexioElectrica) {
        this.connexioElectrica_ = connexioElectrica;
    }

    // El mètode que determina si la parcela funciona correctament
    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica_;
        //Retornarà true si funciona perquè només funciona si existeix connexió elèctrica
    }

    //Mètode toString que retorna amb un string totes les dades d'aquesta classe
    @Override
    public String toString(){
        return super.toString() + " Parcela(mida = " + mida_ + ", connexio electrica = " + connexioElectrica_ + ")";
    }
}
