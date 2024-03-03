public class Motore extends Aereomobile implements Comparabile{
    private double potenzaCV;
    private final static double DEF_POT = 10;


    public Motore(String sigla, double potenzaCV) {
        super(sigla);
        if(potenzaCV > 0)
            this.potenzaCV = potenzaCV;
        else
            this.potenzaCV = DEF_POT;
    }

    public double getPotenzaCV() {
        return potenzaCV;
    }

    @Override
    public boolean isSuperiore(Comparabile x) {
        if(x == null || !(x instanceof Motore)){
            return false;
        }else{
            if(getPotenzaCV()>((Motore) x).getPotenzaCV()){
                return true;
            }else{
                return false;
            }
        }
    }

    public String toString(){
        return super.toString() + " Potenza CV: " + potenzaCV;
    }
}
