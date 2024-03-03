public class Sfera extends Solido{
    private double raggio;

    public Sfera(double ps, double raggio){
        super(ps);
        this.raggio = raggio;
    }

    public double getRaggio() {
        return raggio;
    }

    @Override
    public double getSuperificie() {
        return (4 * Math.PI * raggio * raggio * raggio) / 3;
    }

    @Override
    public double getVolume() {
        return 4/3 * Math.PI * raggio;
    }

    public String toString(){
        return super.toString() + "SFERA: " + " Volume: " + getVolume() +
                " Superificie: " + getSuperificie();
    }
}
