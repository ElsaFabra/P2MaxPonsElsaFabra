package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable {
    private ArrayList<Allotjament> allotjaments;

    public LlistaAllotjaments() {
        this.allotjaments = new ArrayList<>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        for(Allotjament a: allotjaments){
            if (a.getId().equals(allotjament.getId())){
                throw new ExcepcioCamping("Ja existeix aquest allotjament " + allotjament.getNom());
            }
        }
        allotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        allotjaments.clear();
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        if(allotjaments.isEmpty()) {
            throw new ExcepcioCamping("No hi ha allotjaments.");
        }
        String result = "";
        for (Allotjament a: allotjaments){
            if (estat.equals("tots")) {
                result += a.toString();
            } else if (estat.equals("operatiu") && a.isOperatiu()) {
                result += a.toString();
            } else if (estat.equals("no operatiu") && !a.isOperatiu()) {
                result += a.toString();
            }
        }
        if (result.isEmpty()) {
            throw new ExcepcioCamping("No hi ha allotjaments amb aquest estat.");
        }
        return result;
    }

    @Override
    public boolean containsAllotjamentOperatiu() {
        for(Allotjament a: allotjaments){
            if (a.isOperatiu()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        for (Allotjament a: allotjaments){
            if(a.getId().equals(allotjament.getId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for (Allotjament a: allotjaments){
            if(a.getId().equals(id)){
                return a;
            }
        }
        throw new ExcepcioCamping("No existeix cap allotjament amb l'id " + id);
    }
}

