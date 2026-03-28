package prog2.model;

public abstract class AccesAsfalt extends Acces{
    private double metresQuadrats;

    public AccesAsfalt(double metresQuadrats, String nom, boolean accessibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments) {
        super(nom, accessibilitat, estat, llistaAllotjaments);
    }

    public double getMetresQuadrats() {
        return metresQuadrats;
    }

    public void setMetresQuadrats(double metresQuadrats) {
        this.metresQuadrats = metresQuadrats;
    }

}
