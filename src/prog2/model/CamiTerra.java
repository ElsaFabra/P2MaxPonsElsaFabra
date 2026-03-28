package prog2.model;

public class CamiTerra extends AccesTerra{


    public CamiTerra(double longitud, String nom, boolean accessibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments) {
        super(longitud, nom, accessibilitat, estat, llistaAllotjaments);
    }

    public boolean isAccessibilitat(){

        return false;
    }
}


