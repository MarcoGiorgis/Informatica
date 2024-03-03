public class DVD extends Cassetta{
    private static double prezzo = 0;
    private int nLingue;
    private TipoLingua[] lingue;
    private static final int MAX_LINGUE = 5;


    public DVD(String titolo, int durataSec) {
        super(titolo, durataSec);
        lingue = new TipoLingua[MAX_LINGUE];
        nLingue = 0;
    }

    public static double getPrezzo() {
        return prezzo;
    }

    public int getnLingue() {
        return nLingue;
    }

    public static void setPrezzo(double prezzo) {
        if(prezzo >= 0)
            DVD.prezzo = prezzo;
    }

    public double getPrezzoScontato(){
        return prezzo - prezzo / 100 * getSconto();
    }

    public void add(TipoLingua l){
        if(nLingue < MAX_LINGUE && l != null){
            if(ricercaLingua(l) == -1) {
                lingue[nLingue] = l;
                nLingue++;
            }
        }
    }
    private int ricercaLingua(TipoLingua l){
        int tro = -1;
        int k = 0;
        while (k < nLingue && tro == -1){
            if(lingue[k].equals(l))
                tro = k;
            else
                k++;
        }
        return tro;
    }
    public String getLIngue(){
        String str = "";
        for(int k = 0; k < nLingue; k++){
            str += lingue[k];
        }
        return str;
    }

    public String toString() {
        return "Prezzo: " + prezzo + " Numero lingue: " + nLingue + " Lingue: " + getLIngue() + "\n";
    }
}
