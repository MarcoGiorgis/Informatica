public class Autonoleggio {
    private String nome;
    private int indirizzo;
    private final int MAX_VEICOLI;
    private final static int DEFAULT_VEICOLI = 1;
    private int num_veicoli;
    private Veicolo[] vElencoVeicoli;
    private Responsabile responsabile;

    public Autonoleggio(String nome, int indirizzo, int max_veicoli, Responsabile responsabile){
        this.nome = nome;
        this.indirizzo = indirizzo;
        if(max_veicoli < 1)
            MAX_VEICOLI = DEFAULT_VEICOLI;
        else
            MAX_VEICOLI = max_veicoli;
        num_veicoli = 0;
        vElencoVeicoli = new Veicolo[MAX_VEICOLI];
        this.responsabile = responsabile;
    }
    public void aggiungiVeicolo(Veicolo veicolo){
        if(veicolo != null){
            if(num_veicoli < MAX_VEICOLI){
                vElencoVeicoli[num_veicoli] = veicolo;
                num_veicoli++;
            }
        }
    }
    public Veicolo trovaVeicolo(String targa){
        Veicolo veicolo = null; 
        int tro = -1;
        int k = 0;
        while (k < num_veicoli && tro == -1){
            if(targa.equals(vElencoVeicoli[k].getTarga())) {
                veicolo = vElencoVeicoli[k];
                tro = 1;
            } else {
                k++;
            }
        }
        return veicolo;
    }
    public Veicolo[] trovaTuttiVeicoli(){
        Veicolo[] v = new Veicolo[num_veicoli];
        for(int k = 0; k < num_veicoli; k++){
            v[k] = vElencoVeicoli[k];
        }
        return v;
    }
    public String toString(){
        String str = "";
        for(int k = 0; k < num_veicoli; k++){
            str += vElencoVeicoli[k].toString() + "\n";
        }
        return "Nome concessionaria: " + nome + " Indirizzo: " + indirizzo +
                "\n Responsabile: " + responsabile + "\n Veicoli: " + str;
    }
}
