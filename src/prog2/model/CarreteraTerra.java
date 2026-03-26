package prog2.model;

public class CarreteraTerra extends AccesTerra{
    private double amplada;

    public CarreteraTerra(double longitud, String nom, boolean accesibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments) {
        super(longitud, nom, accesibilitat, estat, llistaAllotjaments);
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }
}

