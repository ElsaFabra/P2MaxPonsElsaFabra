package prog2.model;

public abstract class AccesTerra extends Acces {
    private double longitud;

    public AccesTerra(double longitud, String nom, boolean accesibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments) {
        super(nom, accesibilitat, estat, llistaAllotjaments);
    }
}
