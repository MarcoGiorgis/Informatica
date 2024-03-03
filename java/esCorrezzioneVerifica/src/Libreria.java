public class Libreria {
    private String nome;
    private String citta;
    private Libro[] vLibri;
    private int nLibri;
    private final int MAX_LIBRI;
    private static final int DEF_LIBRI = 10;

    public Libreria(String nome, String citta, int max_libri) {
        this.nome = nome;
        this.citta = citta;
        MAX_LIBRI = (max_libri > 0) ? max_libri : DEF_LIBRI;
        vLibri = new Libro[MAX_LIBRI];
        nLibri = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    public Libro[] getvLibri() {
        return vLibri;
    }

    public int getnLibri() {
        return nLibri;
    }

    public void add(Libro l){
        if(l != null){
            if(nLibri < MAX_LIBRI){
                vLibri[nLibri] = l;
                nLibri++;
            }
        }
    }
    public void cambiaPrezzo(String titolo, float perc, char tipoOp){
        int k = 0;
        int tro = -1;
        while (k < nLibri && tro == -1){
            if(vLibri[k].getTitolo().equals(titolo)){
                if(tipoOp == 'a')
                    vLibri[k].setValore(vLibri[k].getValore() + (vLibri[k].getValore() * perc / 100));
                else{
                    if(tipoOp == 'b')
                        vLibri[k].setValore(vLibri[k].getValore() - (vLibri[k].getValore() * perc / 100));
                }
            }
            k++;
        }
    }
    public void Statistica(){
        double min_Horror = 0;
        double min_Giallo = 0;
        double min_Romanzo = 0;
        for (int k = 0; k < nLibri; k++){
            if(vLibri[k].getGenere() == Generi.HORROR){
                if( k == 0)
                    min_Horror = vLibri[k].getValore();
                else{
                    if (vLibri[k].getValore() < min_Horror)
                        min_Horror = vLibri[k].getValore();
                }
            }
            if(vLibri[k].getGenere() == Generi.GIALLO){
                if( k == 0)
                    min_Giallo = vLibri[k].getValore();
                else{
                    if (vLibri[k].getValore() < min_Giallo)
                        min_Giallo = vLibri[k].getValore();
                }
            }
            if(vLibri[k].getGenere() == Generi.ROMANZO){
                if( k == 0)
                    min_Romanzo = vLibri[k].getValore();
                else{
                    if (vLibri[k].getValore() < min_Romanzo)
                        min_Romanzo = vLibri[k].getValore();
                }
            }
        }
        System.out.println(min_Giallo);
        System.out.println(min_Horror);
        System.out.println(min_Romanzo);
    }

    @Override
    public String toString() {
        String str = "";
        float prezzoTotale = 0;
        float prezzoMedio;
        for(int k = 0; k < nLibri; k++){
            str += vLibri[k].toString() + "\n";
            prezzoTotale += vLibri[k].getValore();
        }
        if(nLibri == 0)
            prezzoMedio = 0;
        else
            prezzoMedio = prezzoTotale / nLibri;
        return "Nome: " + nome + " Città: " + citta + str + "Prezzo medio: " + prezzoMedio;
    }
}
