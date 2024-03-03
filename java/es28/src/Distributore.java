public class Distributore {
    private final int MAX_POMPE;
    private int num_pompe;
    private Carburante[] vPompe;
    private String nome;
    private int indirizzo;

    public Distributore(String nome, int indirizzo, int max_pompe){
        this.nome = nome;
        this.indirizzo = indirizzo;
        if(max_pompe < 1)
            MAX_POMPE = 1;
        else
            MAX_POMPE = max_pompe;
        num_pompe = 0;
        vPompe = new Carburante[MAX_POMPE];
    }
    public void add(Carburante pompe){
        if (pompe != null) {
            if (num_pompe < MAX_POMPE) {
                vPompe[num_pompe] = pompe;
                num_pompe++;
            }
        }
    }
    public String getNome(){
        return nome;
    }
    public int getIndirizzo(){
        return indirizzo;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setIndirizzo(int indirizzo){
        this.indirizzo = indirizzo;
    }
    public void aumenta(String tipo, float percentuale) {
        for (int k = 0; k < num_pompe; k++) {
            if (vPompe[k].getTipo() == tipo) {
                float nuovoPrezzo = vPompe[k].getPrezzo() * percentuale / 100;
                vPompe[k].setPrezzo(nuovoPrezzo);
            }
        }
    }
    public String getStatistiche(){
        float prezzoMin = vPompe[0].getPrezzo();
        float prezzoMax = vPompe[0].getPrezzo();
        float somma = 0;
        float media;
        String str = "";
        for(int k = 1; k < num_pompe; k++){
            if(vPompe[k].getPrezzo() > prezzoMax)
                prezzoMax = vPompe[k].getPrezzo();
            if(vPompe[k].getPrezzo() < prezzoMin)
                prezzoMin = vPompe[k].getPrezzo();
            somma += vPompe[k].getPrezzo();
        }
        media = somma / num_pompe;
        str = "Prezzo minimo: " + prezzoMin + " Prezzo massimo: " + prezzoMax + " Media: " + media;
        return str;
    }
    public String toString(){
        String str = "";
        for(int k = 0; k < num_pompe; k++){
            str += "Nome: " + nome + " Indirizzo: " + indirizzo +  vPompe[k].toString() + getStatistiche() + "\n";
        }
        return str;
    }
}
