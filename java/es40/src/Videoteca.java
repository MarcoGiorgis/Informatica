public class Videoteca {
    private String nome;
    private String indirizzo;
    private Cassetta[] vCassette;
    private int nCassette;
    private final int MAX_CASSETTE;
    private static final int DEF_CASSETTE = 10;

    public Videoteca(String nome, String indirizzo, int max_cassette) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        if(max_cassette > 0)
            MAX_CASSETTE = max_cassette;
        else
            MAX_CASSETTE = DEF_CASSETTE;
        vCassette = new Cassetta[MAX_CASSETTE];
        nCassette = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void Add(Cassetta c){
        if(nCassette < MAX_CASSETTE && c!=null){
            vCassette[nCassette]=c;
            nCassette++;
        }
    }

    public void Vendo(int codice){
        int tro = ricercaCodice(codice);
        if(tro != -1)
            vCassette[tro].setnCopie(vCassette[tro].getnCopie() + 1);
    }

    public void Compro(int codice){
        int tro = ricercaCodice(codice);
        if(tro != -1)
            vCassette[tro].setnCopie((vCassette[tro].getnCopie() - 1));
    }
    private int ricercaCodice(int code){
        int tro = -1;
        int k = 0;
        while (k < nCassette && tro == -1){
            if(vCassette[k].getMioCodice() == code) //stessa sintassi di element at
                tro = k;
            else
                k++;
        }
        return tro;
    }

    private double getValoreNegozio(){
        double tot = 0;
        for(int k = 0; k < nCassette; k++){
            if(vCassette[k] instanceof DVD)
                tot += DVD.getPrezzo() * vCassette[k].getnCopie();
            else
                tot += CD.getPrezzo() * vCassette[k].getnCopie();
        }
        return tot;
    }

    public String toString(){
        String str ="";
        for(int k = 0; k < nCassette; k++){
            str = str + vCassette[k].toString();
        }
        return "Nome: " + nome + " Indirizzo: " + indirizzo + " Saldo: " + getValoreNegozio() + "\n" +  str;
    }
}
