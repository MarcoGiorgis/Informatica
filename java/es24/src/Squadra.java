public class Squadra {
    private String nome;
    private final int N_MAX_PLAYER;
    private final static int PLAYER_DEFAULT = 2;
    private int num_player;
    private Giocatore vGiocatori[];
    private String ruolo;
    private final static Ruolo DEF_TIPO_RUOLO = Ruolo.BATTITORE;

    public Squadra(String nome, int max_player, String ruolo){
        if(max_player > 0)
            N_MAX_PLAYER = max_player;
        else
            N_MAX_PLAYER = PLAYER_DEFAULT;
        this.nome = nome;
        this.ruolo = ruolo; //come controllare se è presente l'elemento inserito nell'enumerazione
    }
    public void add(Giocatore giocatore){
        if(giocatore != null){
            if(num_player < N_MAX_PLAYER){
                vGiocatori[num_player] = giocatore;
                num_player++;
            }
        }
    }
    public void setPunteggio(String nome, double valore){
        for(int k = 0; k < num_player; k++){
            if(vGiocatori[k].equals(nome)){
                vGiocatori[k].setPunteggio(valore);
            }
        }
    }
    public double getPunteggioMedio(){
        double somma = 0;
        double media;
        for(int k = 0; k < num_player; k++){
            somma += vGiocatori[k].getPunteggio();
        }
        media = somma / num_player;
        return media;
    }
    public void passatoAnno(){
        for(int k = 0; k < num_player; k++){
            vGiocatori[k].setEta(vGiocatori[k].getEta() + 1);
        }
    }
    public String toString(){
        String str = "";
        str = "Nome squadra: " + nome;
        for(int k = 0; k < num_player; k++){
            str += vGiocatori[k].toString() + "\n";
        }
        str += " Punteggio medio: " + getPunteggioMedio();
        return str;
    }
}
