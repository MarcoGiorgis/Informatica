public class Cubo extends Solido{
    private double lato;

    public Cubo(double ps, double lato){
        super(ps);
        if(lato >= 0)
            this.lato = lato;
        else
            this.lato = 1;
    }

    public double getLato() {
        return lato;
    }

    @Override
    public double getSuperificie() {
        return lato * lato * 6;
    }

    @Override
    public double getVolume() {
        return lato * lato * lato;
    }
    public String toString(){
        return super.toString() + "CUBO: " + " Volume: " + getVolume() +
                " Superificie: " + getSuperificie();
    }
}
