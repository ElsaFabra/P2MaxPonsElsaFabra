package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt{


    public CarreteraAsfalt(double metresQuadrats, String nom, boolean accesibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments) {
        super(metresQuadrats, nom, accesibilitat, estat, llistaAllotjaments);
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }
}
