package prog2.model;

import java.io.Serializable;

public class CamiTerra extends AccesTerra implements Serializable {


    public CamiTerra(String nom, boolean estat, double longitud) {
        super(nom, estat, longitud);
    }

    @Override
    public boolean isAccessibilitat(){
        return false;
    }

    @Override
    public String toString(){
        return "CamiTerra{" + super.toString() + "}";
    }
}

