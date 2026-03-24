package prog2.model;

/** Definició de la classe que representa
 * els allotjaments. Queda definida per la seva interfície InAllotjament.
 * **/
public abstract class Allotjament implements InAllotjament {
    //Declaració dels atributs
    private String nom; //Nom de l'allotjament
    private String identificador; //Nom de l'identificador de l'allotjament
    private long estadaMinimaALTA; // Estada minima a l'allotjament en temporada alta
    private long estadaMinimaBAIXA; // Estada minima a l'allotjament en temporada baixa

    //Constructor de la classe allotjament i inicialització dels atributs aprofitant els setters
    public Allotjament(String nom, String identificador, long estadaMinimaALTA, long estadaMinimaBAIXA) {
        setNom(nom);
        setId(identificador);
        setEstadaMinima(estadaMinimaALTA, estadaMinimaBAIXA);
    }

    //Getters i setters de cada atribut privat per accedir a ells
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getId() {
        return identificador;
    }

    @Override
    public void setId(String id) {
        this.identificador = id;
    }

    //Usant l'enum temp definit a la interfície aquest getter retorna la temporada corresponent
    @Override
    public long getEstadaMinima(Temp temp) {
        if (temp == Temp.ALTA) {
            return estadaMinimaALTA;
        } else {
            return estadaMinimaBAIXA;
        }
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA, long estadaMinimaBAIXA) {
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
    }

    /**Declaració del mètode correcteFuncionament que aplicaré després a cada subclasse
     * modificada segons els requisits de cadascuna**/
    @Override
    public abstract boolean correcteFuncionament();

    //Mètode toString que retorna amb un string totes les dades d'aquesta classe
    @Override
    public String toString(){
        return "Nom=" + nom + ", Id=" + identificador +
                ", estada mínima en temp ALTA: " + estadaMinimaALTA +
                ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA + ".";
    }
}
