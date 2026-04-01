package prog2.model;

import java.io.Serializable;

public abstract class AccesAsfalt extends Acces implements Serializable {
    private double metresQuadrats;

    public AccesAsfalt(String nom, boolean estat, double metresQuadrats) {
        super(nom, estat);
        this.metresQuadrats = metresQuadrats;
    }

    public double getMetresQuadrats() {
        return metresQuadrats;
    }

    public void setMetresQuadrats(double metresQuadrats) {
        this.metresQuadrats = metresQuadrats;
    }

    @Override
    public String toString(){
        return super.toString() + ", metresQuadrats=" + metresQuadrats;
    }
}
