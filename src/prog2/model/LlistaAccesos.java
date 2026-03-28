package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAccesos implements InLlistaAccessos{
    private ArrayList<Acces> accessos;

    public LlistaAccesos(){
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
