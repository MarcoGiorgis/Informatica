public class Quadro {
    private String titolo;
    private String autore;
    private Tecniche tecnica;
    private double valore;
    private final static int DEF_VAL = 100;

    public Quadro(String titolo, String autore, Tecniche tecnica, double valore){
        this.titolo = titolo;
        this.autore = autore;
        this.tecnica = tecnica;
        if(valore > 0)
            this.valore = valore;
        else
            this.valore = DEF_VAL;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public double getValore() {
        return valore;
    }

    public Tecniche getTecnica() {
        return tecnica;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setValore(double valore) {
        if(valore > 0)
            this.valore = valore;
        else
            this.valore = DEF_VAL;
    }

    public void setTecnica(Tecniche tecnica) {
        this.tecnica = tecnica;
    }
    public boolean isParagonabile(Quadro q){
        boolean stessoValoreTipo = false;
        if(q.getValore() == this.valore && q.getTecnica().equals(this.tecnica)) {
            stessoValoreTipo = true;
        }
        return stessoValoreTipo;
    }

    public String toString() {
        return "Titolo: " + titolo + " Autore: " + autore + " Valore: " + valore + " Tecnica: " + tecnica;
    }
}
