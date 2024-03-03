public class Alianti extends Aereomobile implements Comparabile{
    public int numAereodinamica;
    private final static int DEF_NAEREO = 10;

    public Alianti(String sigla, int numAereodinamica) {
        super(sigla);
        if(numAereodinamica > 0)
            this.numAereodinamica = numAereodinamica;
        else
            this.numAereodinamica = DEF_NAEREO;
    }

    public int getNumAereodinamica() {
        return numAereodinamica;
    }

    @Override
    public boolean isSuperiore(Comparabile x) {
        if(x == null || !(x instanceof Alianti)){
            return false;
        }else{
            if(getNumAereodinamica()>((Alianti) x).getNumAereodinamica()){
                return true;
            }else{
                return false;
            }
        }
    }

    public String toString(){
        return super.toString() + " Aereodinamica: " + numAereodinamica;
    }
}
