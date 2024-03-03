public class CD extends Cassetta{
    private static double prezzo;
    private int nBrani;
    private static final int DEF_BRANI = 10;


    public CD(String titolo, int durataSec, int nBrani) {
        super(titolo, durataSec);
        if(nBrani > 0)
            this.nBrani = nBrani;
        else
            this.nBrani = DEF_BRANI;
    }

    public static double getPrezzo() {
        return prezzo;
    }

    public int getnBrani() {
        return nBrani;
    }

    public static void setPrezzo(double prezzo) {
        if(prezzo > 0)
            CD.prezzo = prezzo; //attributo di classe (attributo di instanza->this)
    }

    public double getPrezzoScontato(){
        return prezzo - prezzo / 100 * getSconto();
    }

    public String toString() {
        return super.toString() + "CD: " + "Numero Brani: " + nBrani;
    }
}
