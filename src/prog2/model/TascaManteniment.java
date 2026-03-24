package prog2.model;

public class TascaManteniment implements InTascaManteniment{
    private int num;
    private String data;
    private int dies;

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() {
        return null;
    }

    @Override
    public Allotjament getAllotjament() {
        return null;
    }

    @Override
    public String getData() {
        return "";
    }

    @Override
    public int getDies() {
        return 0;
    }

    @Override
    public void setNum(int num) {

    }

    @Override
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus) {

    }

    @Override
    public void setAllotjament(Allotjament allotjament) {

    }

    @Override
    public void setData(String data) {

    }

    @Override
    public void setDies(int dies) {

    }

    @Override
    public String getIluminacioAllotjament() {
        return "";
    }
}
