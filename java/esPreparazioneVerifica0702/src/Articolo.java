public abstract class Articolo {
    private int idArticolo;
    private String titolo;
    private double valore;
    private Utente inPrestitoA;
    private static int progressivoArticolo;

    public Articolo(String titolo, double valore) {
        this.idArticolo = progressivoArticolo;
        this.titolo = titolo;
        this.valore = valore;
        this.inPrestitoA = null;
        progressivoArticolo ++;
    }

    public int getIdArticolo() {
        return idArticolo;
    }

    public void setIdArticolo(int idArticolo) {
        this.idArticolo = idArticolo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public double getValore() {
        return valore;
    }

    public void setValore(double valore) {
        this.valore = valore;
    }

    public Utente getInPrestitoA() {
        return inPrestitoA;
    }

    public void setInPrestitoA(Utente inPrestitoA) {
        this.inPrestitoA = inPrestitoA;
    }

    public static int getProgressivoArticolo() {
        return progressivoArticolo;
    }

    public static void setProgressivoArticolo(int progressivoArticolo) {
        Articolo.progressivoArticolo = progressivoArticolo;
    }

    @Override
    public String toString() {
        return "Articolo{" +
                "idArticolo=" + idArticolo +
                ", titolo='" + titolo + '\'' +
                ", valore=" + valore +
                ", inPrestitoA=" + inPrestitoA +
                '}';
    }
}
