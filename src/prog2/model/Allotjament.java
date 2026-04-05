package prog2.model;

import java.io.Serializable;

/**
 * Classe abstracta que representa un allotjament del càmping.
 * Conté els atributs comuns a tots els allotjaments i implementa la interfície {@link InAllotjament}.
 * Les subclasses han d'implementar el mètode {@link #correcteFuncionament()}.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public abstract class Allotjament implements InAllotjament, Serializable {

    /** Nom de l'allotjament. */
    private String nom;

    /** Identificador únic de l'allotjament. */
    private String identificador;

    /** Estada mínima en temporada alta en dies. */
    private long estadaMinimaALTA;

    /** Estada mínima en temporada baixa en dies. */
    private long estadaMinimaBAIXA;

    /** Estat operatiu de l'allotjament: true si és operatiu, false si no ho és. */
    private boolean estatAllotjament;

    /** Percentatge d'il·luminació de l'allotjament ("100%", "50%", "0%"). */
    private String estatIluminacio;

    /**
     * Constructor de la classe Allotjament.
     * @param nom Nom de l'allotjament.
     * @param identificador Identificador únic de l'allotjament.
     * @param estatAllotjament Estat operatiu inicial (true=operatiu).
     * @param estatIluminacio Percentatge d'il·luminació inicial.
     * @param estadaMinimaALTA Estada mínima en temporada alta en dies.
     * @param estadaMinimaBAIXA Estada mínima en temporada baixa en dies.
     */
    public Allotjament(String nom, String identificador, boolean estatAllotjament,
                       String estatIluminacio, long estadaMinimaALTA, long estadaMinimaBAIXA) {
        setNom(nom);
        setId(identificador);
        setEstatAllotjament(estatAllotjament);
        setEstatIluminacio(estatIluminacio);
        setEstadaMinima(estadaMinimaALTA, estadaMinimaBAIXA);
    }

    /**
     * Retorna si l'allotjament és operatiu.
     * @return true si és operatiu, false si no ho és.
     */
    public boolean isOperatiu() {
        return estatAllotjament;
    }

    /**
     * Modifica l'estat operatiu de l'allotjament.
     * @param estatAllotjament Nou estat operatiu.
     */
    public void setEstatAllotjament(boolean estatAllotjament) {
        this.estatAllotjament = estatAllotjament;
    }

    /**
     * Retorna el percentatge d'il·luminació de l'allotjament.
     * @return Percentatge d'il·luminació ("100%", "50%", "0%").
     */
    public String getIluminacio() {
        return estatIluminacio;
    }

    /**
     * Modifica el percentatge d'il·luminació de l'allotjament.
     * @param estatIluminacio Nou percentatge d'il·luminació.
     */
    public void setEstatIluminacio(String estatIluminacio) {
        this.estatIluminacio = estatIluminacio;
    }

    /**
     * Retorna el nom de l'allotjament.
     * @return Nom de l'allotjament.
     */
    @Override
    public String getNom() { return nom; }

    /**
     * Modifica el nom de l'allotjament.
     * @param nom Nou nom de l'allotjament.
     */
    @Override
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Retorna l'identificador únic de l'allotjament.
     * @return Identificador de l'allotjament.
     */
    @Override
    public String getId() { return identificador; }

    /**
     * Modifica l'identificador de l'allotjament.
     * @param id Nou identificador de l'allotjament.
     */
    @Override
    public void setId(String id) { this.identificador = id; }

    /**
     * Retorna l'estada mínima segons la temporada indicada.
     * @param temp Temporada (ALTA o BAIXA).
     * @return Estada mínima en dies per a la temporada indicada.
     */
    @Override
    public long getEstadaMinima(Temp temp) {
        if (temp == Temp.ALTA) return estadaMinimaALTA;
        else return estadaMinimaBAIXA;
    }

    /**
     * Modifica les estades mínimes de l'allotjament.
     * @param estadaMinimaALTA Nova estada mínima en temporada alta.
     * @param estadaMinimaBAIXA Nova estada mínima en temporada baixa.
     */
    @Override
    public void setEstadaMinima(long estadaMinimaALTA, long estadaMinimaBAIXA) {
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
    }

    /**
     * Determina si l'allotjament funciona correctament.
     * Cada subclasse defineix el seu criteri de funcionament correcte.
     * @return true si funciona correctament, false si no.
     */
    public abstract boolean correcteFuncionament();

    /**
     * Retorna una representació en String de l'allotjament.
     * @return String amb el nom, id i estades mínimes de l'allotjament.
     */
    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + identificador +
                ", estada mínima en temp ALTA: " + estadaMinimaALTA +
                ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA + ".";
    }

    /**
     * Tanca l'allotjament posant-lo com a no operatiu i ajustant la il·luminació
     * segons el tipus de tasca de manteniment.
     * @param tasca Tasca de manteniment que determina la il·luminació.
     */
    @Override
    public void tancarAllotjament(TascaManteniment tasca) {
        this.setEstatAllotjament(false);
        this.setEstatIluminacio(tasca.getIluminacioAllotjament());
    }

    /**
     * Obre l'allotjament posant-lo com a operatiu i la il·luminació al 100%.
     */
    @Override
    public void obrirAllotjament() {
        this.setEstatAllotjament(true);
        this.setEstatIluminacio("100%");
    }
}