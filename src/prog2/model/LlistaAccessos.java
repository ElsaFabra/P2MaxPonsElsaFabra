package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos, Serializable {
    private ArrayList<Acces> accessos;

    public LlistaAccessos(){
        this.accessos = new ArrayList<>();
    }

    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        accessos.add(acc);
    }

    @Override
    public void buidar() {
        accessos.clear();
    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
    return "";
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for (Acces acces: accessos){
            if(!acces.getAAllotjaments().containsAllotjamentOperatiu()){
                acces.setEstat(false);
            } else {
                acces.setEstat(true);
            }
        }
    }

    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        return 0;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        return 0;
    }
}
