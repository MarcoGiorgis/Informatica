public abstract class Solido implements FiguraSolida, CorpoSolido{ //implementa due interfaccie non si può fare new solido
    private double pesoSpecifico; //premere alt+invio per errori

    public Solido(double pesoSpecifico) {
        this.pesoSpecifico = pesoSpecifico;
    }

    public double getPesoSpecifico() {
        return pesoSpecifico;
    }

    @Override
    public double getPeso() {
        return getVolume() * pesoSpecifico;
    }
}
