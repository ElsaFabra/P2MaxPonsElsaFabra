package prog2.model;

public class CamiAsfaltat extends AccesAsfalt{


    public CamiAsfaltat(double metresQuadrats, String nom, boolean accessibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments) {
        super(metresQuadrats, nom, accessibilitat, estat, llistaAllotjaments);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}

