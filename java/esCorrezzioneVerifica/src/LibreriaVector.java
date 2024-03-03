import java.util.Vector;

public class LibreriaVector {
    private String nome;
    private String citta;
    private Vector<Libro> vLibri;

    public LibreriaVector(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
        vLibri = new Vector<Libro>();
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    public Vector<Libro> getvLibri() {
        return vLibri;
    }

    public int getnLibri(){
        return vLibri.size();
    }

    public void add(Libro l){
        if(l != null){
            vLibri.add(l);
        }
    }
    public void cambiaPrezzo(String titolo, float perc, char tipoOp){
        int k = 0;
        int tro = -1;
        while (k < vLibri.size() && tro == -1){
            if(vLibri.get(k).getTitolo().equals(titolo)){
                if(tipoOp == 'a')
                    vLibri.get(k).setValore(vLibri.get(k).getValore() + (vLibri.get(k).getValore() * perc / 100));
                else{
                    if(tipoOp == 'b')
                        vLibri.get(k).setValore(vLibri.get(k).getValore() - (vLibri.get(k).getValore() * perc / 100));
                }
            }
            k++;
        }
    }
    public void Statistica(){
        double min_Horror = 0;
        double min_Giallo = 0;
        double min_Romanzo = 0;
        for (int k = 0; k < vLibri.size(); k++){
            if(vLibri.get(k).getGenere() == Generi.HORROR){
                if( k == 0)
                    min_Horror = vLibri.get(k).getValore();
                else{
                    if (vLibri.get(k).getValore() < min_Horror)
                        min_Horror = vLibri.get(k).getValore();
                }
            }
            if(vLibri.get(k).getGenere() == Generi.GIALLO){
                if( k == 0)
                    min_Giallo = vLibri.get(k).getValore();
                else{
                    if (vLibri.get(k).getValore() < min_Giallo)
                        min_Giallo = vLibri.get(k).getValore();
                }
            }
            if(vLibri.get(k).getGenere() == Generi.ROMANZO){
                if( k == 0)
                    min_Romanzo = vLibri.get(k).getValore();
                else{
                    if (vLibri.get(k).getValore() < min_Romanzo)
                        min_Romanzo = vLibri.get(k).getValore();
                }
            }
        }
        System.out.println(min_Giallo);
        System.out.println(min_Horror);
        System.out.println(min_Romanzo);
    }
    private int cercaGenere(Generi g){
        int tro = -1;
        int k = 0;
        while (k < Generi.values().length && tro == -1){
            if(g == Generi.values()[k])
                tro = k;
            else
                k++;
        }
        return tro;
    }
    public void Statistica2(){
        double[] vMin = new double[Generi.values().length];
        int[] vCont = new int[Generi.values().length];
        int posGenere;

        for(Libro l: vLibri){
            posGenere = cercaGenere(l.getGenere());
            if(vCont[posGenere] == 0)
                vMin[posGenere] = l.getValore();
            else if(l.getValore() < vMin[posGenere])
                vMin[posGenere] = l.getValore();
            vCont[posGenere] ++;
        }
        for(int k = 0; k < Generi.values().length; k++){
            System.out.println(Generi.values()[k] + ": " + vMin[k]);
        }
    }

    @Override
    public String toString() {
        String str = "";
        float prezzoTotale = 0;
        float prezzoMedio;
        for(Libro l: vLibri){
            str += l.toString() + "\n";
            prezzoTotale += l.getValore();
        }
        if(vLibri.size() == 0)
            prezzoMedio = 0;
        else
            prezzoMedio = prezzoTotale / vLibri.size();
        return "Nome: " + nome + " Città: " + citta + str + "Prezzo medio: " + prezzoMedio;
    }
}
