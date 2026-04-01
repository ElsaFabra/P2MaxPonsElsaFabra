package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment, Serializable {
    private ArrayList<TascaManteniment> tasques;

    public LlistaTasquesManteniment(){
        this.tasques = new ArrayList<>();
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
        for(TascaManteniment t: tasques){
            if (t.getAllotjament().getId().equals(allotjament.getId())){
                throw new ExcepcioCamping("Ja existeix una tasca de manteniment per l'allotjament " + allotjament.getNom());
            }
        }
        TascaManteniment.TipusTascaManteniment tipusEnum;
        try {
            tipusEnum = TascaManteniment.TipusTascaManteniment.valueOf(tipus);
        }catch (IllegalArgumentException e){
            throw new ExcepcioCamping("El tipus de tasca " + tipus + "no existeix.");
        }

        TascaManteniment tasca = new TascaManteniment(num, tipusEnum, allotjament, data, dies);
        tasques.add(tasca);
        allotjament.tancarAllotjament(tasca);
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
