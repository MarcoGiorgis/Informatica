import java.util.Vector;

public class Azienda {
    private String nome;
    private String indirizzo;
    private Vector<Lavoratore> lavoratori;

    public Azienda(String nome, String indirizzo){
        this.nome = nome;
        this.indirizzo = indirizzo;
        lavoratori = new Vector<Lavoratore>();
    }
    public void add(Lavoratore l){
        if(l != null){
            lavoratori.add(l);
        }
    }
    public String getNome() {
        return nome;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public String toString(){
        String str = "";
        for(int k = 0; k < lavoratori.size(); k++){
            str += lavoratori.toString() + "\n";
        }
        return "Nome: " + nome + " Indirizzo: " + indirizzo + str;
    }
}
