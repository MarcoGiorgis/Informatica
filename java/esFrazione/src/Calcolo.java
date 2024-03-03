public class Calcolo {
    private final static int DEF_MIN = 2;
    private final static int DEF_MAX = 10;
    private final int MAX_FRA;
    private Frazione[] vFrazione;
    private int num_fra;
    private Operazioni operazione;
    //private final static Operazioni DEF_OPE = Operazioni.SOMMA;

    public Calcolo(Operazioni operazione, int max_fra){
        this.operazione = operazione;
        if(max_fra > 0)
            MAX_FRA = max_fra;
        else
            MAX_FRA = DEF_MAX;
        num_fra = 0;
        vFrazione = new Frazione[MAX_FRA];
    }
    public void add(Frazione f){
        if(f != null){
            if(num_fra < MAX_FRA){
                vFrazione[num_fra] = f;
                num_fra++;
            }
        }
    }
    public double getValore(){
        double calcolo = vFrazione[0].getValore();
        if(num_fra > 1)
            for(int k = 1; k < num_fra; k++) {
                switch (operazione) {
                    case SOMMA:
                        calcolo += vFrazione[k].getValore();
                        break;
                    case SOTTRAZIONE:
                        calcolo -= vFrazione[k].getValore();
                        break;
                    case MOLTIPLICAZIONE:
                        calcolo *= vFrazione[k].getValore();
                        break;
                    case DIVISIONE:
                        calcolo /= vFrazione[k].getValore();
                        break;
                    default:
                        break;
                }
            }
        return calcolo;
    }
    public String toString(){
        String str = "";
        for(int k = 0; k < num_fra; k++){
            str = vFrazione[k].toString() + operazione;
        }
        return str + getValore();
    }
}
