package prog2.model;

public class CarreteraTerra extends AccesTerra{
    private double amplada;

    public CarreteraTerra(double amplada, double longitud, String nom, boolean accessibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments) {
        super(longitud, nom, accessibilitat, estat, llistaAllotjaments);
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
}

