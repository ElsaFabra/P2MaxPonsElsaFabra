package prog2.model;

public class CarreteraAsfaltada extends AccesAsfalt{
    private double maximPes;

    public CarreteraAsfaltada(double maximPes, double metresQuadrats, String nom, boolean accessibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments) {
        super(metresQuadrats, nom, accessibilitat, estat, llistaAllotjaments);
        this.maximPes = maximPes;
    }

    public double getMaximPes() {
        return maximPes;
    }

    public void setMaximPes(double maximPes) {
        this.maximPes = maximPes;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }
}
