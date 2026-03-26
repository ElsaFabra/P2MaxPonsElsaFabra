package prog2.model;

public abstract class AccesAsfalt extends Acces{
    private double metresQuadrats;

    public AccesAsfalt(double metresQuadrats, String nom, boolean accesibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments) {
        super(nom, accesibilitat, estat, llistaAllotjaments);
    }

    public double getMetresQuadrats() {
        return metresQuadrats;
    }

    public void setMetresQuadrats(double metresQuadrats) {
        this.metresQuadrats = metresQuadrats;
    }

}
