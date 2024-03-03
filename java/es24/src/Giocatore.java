public class Giocatore {
    private String nome;
    private double punteggio;
    private int eta;
    private final double DEFAULT_PUNTEGGIO = 1.0;

    public Giocatore(String nome, int eta){
        this.nome = nome;
        this.eta = eta;
        this.punteggio = DEFAULT_PUNTEGGIO;
    }
    public Giocatore(String nome, int eta, double valore){
        this.nome = nome;
        this.eta = eta;
        if(valore > 0){
            this.punteggio = valore;
        }
    }
    public String getNome(){
        return nome;
    }
    public double getPunteggio(){
        return punteggio;
    }
    public void setPunteggio(double nuovoPunteggio){
        if(nuovoPunteggio > 0)
            this.punteggio = nuovoPunteggio;
    }
    public int getEta(){
        return eta;
    }
    public void setEta(int eta){
        if(eta > 0){
            this.eta = eta;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return "Nome: " + getNome() + " Età: " + getEta() + " Punteggio: " + getPunteggio();
    }
}
