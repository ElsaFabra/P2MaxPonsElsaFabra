package prog2.model;

import java.io.Serializable;

public class CarreteraTerra extends AccesTerra implements Serializable {
    private double amplada;

    public CarreteraTerra(String nom, boolean estat, double longitud, double amplada) {
        super(nom, estat, longitud);
        this.amplada = amplada;
    }

    public double getAmplada() {
        return amplada;
    }

    public void setAmplada(double amplada) {
        this.amplada = amplada;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    @Override
    public String toString() {
        return "CarreteraTerra{" + super.toString() + ", amplada=" + amplada + "}";
    }
}


