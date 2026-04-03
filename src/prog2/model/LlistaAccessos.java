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
        for (Acces a: accessos){
            if(a.getNom().equals(acc.getNom())){
                throw new ExcepcioCamping("Ja esxisteix un accés amb el nom " + acc.getNom());
            }
        }
        accessos.add(acc);
    }

    @Override
    public void buidar() {
        accessos.clear();
    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        String resultat = "";
        for(Acces acc: accessos){
            if(acc.getEstat() == estat){
                resultat = resultat + acc.toString() + "\n";
            }
        }
        if (resultat.isEmpty()) {
            throw new ExcepcioCamping("No hi ha accessos amb aquest estat");
        }
        return resultat;
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
        int accNo = 0;
        for (Acces acc: accessos){
            if(!acc.isAccessibilitat()){
                accNo++;
            }
        }
        return accNo;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        float metres = 0;
        for (Acces acc: accessos){
            if(acc instanceof AccesTerra){
                metres += ((AccesTerra) acc).getLongitud();
            }
        }
        return metres;
    }
}
