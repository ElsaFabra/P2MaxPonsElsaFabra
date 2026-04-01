package prog2.model;

import java.io.Serializable;

public class CarreteraAsfaltada extends AccesAsfalt implements Serializable {
    private double pesMaxim;

    public CarreteraAsfaltada(String nom, boolean estat, double metresQuadrats, double pesMaxim) {
        super(nom, estat, metresQuadrats);
        this.pesMaxim = pesMaxim;
    }

    public double getPesMaxim() {
        return pesMaxim;
    }

    public void setMaximPes(double pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    @Override
    public String toString(){
        return "CarreteraAsfalt{" + super.toString() + ", pesMaxim=" + pesMaxim + "}";
    }
}
