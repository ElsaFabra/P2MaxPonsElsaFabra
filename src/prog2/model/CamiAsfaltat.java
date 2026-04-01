package prog2.model;

import java.io.Serializable;

public class CamiAsfaltat extends AccesAsfalt implements Serializable {


    public CamiAsfaltat(String nom, boolean estat, double metresQuadrats) {
        super(nom, estat, metresQuadrats);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    @Override
    public String toString(){
        return "CamiAsfalt{" + super.toString() + "}";
    }
}

