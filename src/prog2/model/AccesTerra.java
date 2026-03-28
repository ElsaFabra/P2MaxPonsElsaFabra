package prog2.model;

public abstract class AccesTerra extends Acces {
    private double longitud;

    public AccesTerra(double longitud, String nom, boolean accessibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments) {
        super(nom, accessibilitat, estat, llistaAllotjaments);
    }
}
