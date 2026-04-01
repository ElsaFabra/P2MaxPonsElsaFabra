package prog2.model;

import java.io.Serializable;

public class TascaManteniment implements InTascaManteniment, Serializable {

    public static enum TipusTascaManteniment {
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    };

    private int num;
    private Allotjament allotjament;
    private String data;
    private TipusTascaManteniment tipus;
    private int dies;

    public TascaManteniment(int num, TipusTascaManteniment tipus, Allotjament allotjament, String data,
                            int dies){
    this.num = num;
    this.allotjament = allotjament;
    this.data = data;
    this.tipus = tipus;
    this.dies = dies;
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() {
        return tipus;
    }

    @Override
    public Allotjament getAllotjament() {
        return allotjament;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public int getDies() {
        return dies;
    }

    @Override
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus) {
        this.tipus = tipus;
    }

    @Override
    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public void setDies(int dies) {
        this.dies = dies;
    }

    @Override
    public String getIluminacioAllotjament() {
        switch (tipus){
            case Reparacio, RevisioTecnica: return "50%";
            case Neteja: return "100%";
            case Desinfeccio: return "0%";
            default: return "0%";
        }
    }

    @Override
    public String toString(){
        return "TascaManteniment{" +
                "numTasca=" + num +
                ", allotjament=" + allotjament.getNom() +
                ", data=" + data +
                ", tipus=" + tipus +
                ", dies=" + dies +
                ", iluminacio=" + getIluminacioAllotjament() +
                '}';
    }
}