public abstract class Solido {
    private double pesoSpecifico;

    public Solido(double ps){
        if(ps > 0)
            pesoSpecifico = ps;
        else
            pesoSpecifico = 1;
    }
    public double getPesoSpecifico() {
        return pesoSpecifico;
    }
    public abstract double getSuperificie();
    public abstract double getVolume();
    public double getPeso(){
        return pesoSpecifico * getVolume();
    }
    public String toString() {
        return "Peso specifico: " + pesoSpecifico;
    }
}
