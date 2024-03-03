public abstract class Cassetta {
    private static int codice = 0;
    private int mioCodice;
    private String titolo;
    private int durataSec;
    private double sconto;
    private int nCopie;
    private static final int DEF_DUR_SEC = 10;
    private static final double DEF_SCONTO = 10;

    public Cassetta(String titolo, int durataSec) {
        this.titolo = titolo;
        if(durataSec > 0)
            this.durataSec = durataSec;
        else
            this.durataSec = DEF_DUR_SEC;
        mioCodice = codice++;
        sconto = 0;
        nCopie = 0;
    }

    public int getMioCodice() {
        return mioCodice;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getDurataSec() {
        return durataSec;
    }

    public double getSconto() {
        return sconto;
    }

    public int getnCopie() {
        return nCopie;
    }

    public void setSconto(double sconto) {
        if(sconto > 0)
            this.sconto = sconto;
    }

    public void setnCopie(int nCopie) {
        if(nCopie >= 0)
            this.nCopie = nCopie;
    }

    public String toString() {
        return "Cassetta: " + " titolo: " + titolo +  " Durata Secondi: "
                + durataSec + " Sconto: " + sconto + " Numero Copie: " + nCopie;
    }
}
