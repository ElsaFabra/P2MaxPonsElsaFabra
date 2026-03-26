package prog2.model;

public class CamiAsfalt extends AccesAsfalt{


    public CamiAsfalt(double metresQuadrats, String nom, boolean accesibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments) {
        super(metresQuadrats, nom, accesibilitat, estat, llistaAllotjaments);
    }

    @Override
    public boolean isAccesibilitat(){
        return false;
    }
}

