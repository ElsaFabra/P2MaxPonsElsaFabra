package prog2.model;

public abstract class Acces implements InAcces{
    public Acces(){

    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) {

    }

    @Override
    public void tancarAcces() {

    }

    @Override
    public void obrirAcces() {

    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }


    @Override
    public String getNom() {
        return "";
    }

    @Override
    public boolean getEstat() {
        return false;
    }

    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return null;
    }

    public String toString(){
        return "";
    }
}
