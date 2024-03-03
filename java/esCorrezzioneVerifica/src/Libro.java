public class Libro {
    private String titolo;
    private String autore;
    private Generi genere;
    private int nPagine;
    private double valore;
    private static final int DEF_NPAGINE = 100;
    private static final double DEF_VAL = 20;

    public Libro(String titolo, String autore, Generi genere, int nPagine, double valore) {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.nPagine = (nPagine > 0) ? nPagine : DEF_NPAGINE;
        this.valore = (valore >= 0) ? valore : DEF_VAL;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public Generi getGenere() {
        return genere;
    }

    public int getnPagine() {
        return nPagine;
    }

    public double getValore() {
        return valore;
    }
    public void setValore(double valore){
        if(valore > 0)
            this.valore = valore;
    }
    public int compareTo(Libro altroLibro){
        double prezzoPagina1 = this.valore / this.nPagine;
        double prezzoPagina2 = altroLibro.getValore() / altroLibro.getnPagine();
        if(prezzoPagina1 < prezzoPagina2) {
            return -1;
        } else {
            if(prezzoPagina1 > prezzoPagina2)
                return 1;
            else
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Libro: " + " titolo: " + titolo + " autore: " + autore + " genere: " + genere +
                " numero pagine: " + nPagine + " valore: " + valore;
    }
}
