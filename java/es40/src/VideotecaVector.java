import java.util.Vector;

public class VideotecaVector {
    private String nome;
    private String indirizzo;
    private Vector<Cassetta> cassette;

    public VideotecaVector(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        cassette = new Vector<Cassetta>();
    }
    public void add(Cassetta c){
        if(c != null){
            cassette.add(c);
        }
    }
    public String getNome() {
        return nome;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public double getValoreNegozio(){
        double tot = 0;
        for(int k = 0; k < cassette.size(); k++){
            if(cassette.elementAt(k) instanceof DVD)
                tot += DVD.getPrezzo()*
                        cassette.elementAt(k).getnCopie();
            else
                tot += ((CD)cassette.elementAt(k)).getPrezzo()*
                        cassette.elementAt(k).getnCopie();
        }
        return tot;
    }
    private int ricercaCodice(int code){
        int tro = -1;
        int k = 0;
        while (k < cassette.size() && tro == -1){
            if(cassette.get(k).getMioCodice() == code) //stessa sintassi di element at
                tro = k;
            else
                k++;
        }
        return tro;
    }
    public void compro(int codice){
        int tro = ricercaCodice(codice);
        if(tro != -1)
            cassette.get(tro).setnCopie(cassette.get(tro).getnCopie() + 1);
    }
    public void vendo(int codice){
        int tro = ricercaCodice(codice);
        if(tro != -1)
            cassette.get(tro).setnCopie(cassette.get(tro).getnCopie() - 1);
    }

    @Override
    public String toString() {
        return "VideotecaVector{" +
                "nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", cassette=" + cassette +
                '}';
    }
}
