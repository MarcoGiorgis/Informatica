public class Lavoratore {
    private String nome;
    private int livello;
    private double stipendio;
    private static final int DEF_LIV = 0;
    private static final double DEF_STIP = 1000;
    private static final int MAX_LIVELLO = 5;
    private static final int MIN_LIVELLO = 1;

    public Lavoratore(String nome, int livello) {
        this.nome = nome;
        if(livello > MIN_LIVELLO && livello <= MAX_LIVELLO)
            this.livello = livello;
        else
            this.livello = DEF_LIV;
        this.stipendio = DEF_STIP;
    }

    public String getNome() {
        return nome;
    }

    public int getLivello() {
        return livello;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setLivello(int livello) {
        if(livello >= 0 && livello <= 5)
            this.livello = livello;
        else
            this.livello = DEF_LIV;
    }

    public void setStipendio(double stipendio) {
        if(stipendio > 0)
            this.stipendio = stipendio;
        else
            this.stipendio = DEF_STIP;
    }
    public String toString(){
        return "Lavoratore: " + nome + " Livello: " + livello + " Stipendio Base: " + stipendio;
    }
}
