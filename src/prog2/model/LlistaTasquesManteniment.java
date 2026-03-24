package prog2.model;

import prog2.vista.ExcepcioCamping;

public class LlistaTasquesManteniment  implements InLlistaTasquesManteniment{
    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {

    }

    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {

    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return "";
    }

    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        return null;
    }
}
