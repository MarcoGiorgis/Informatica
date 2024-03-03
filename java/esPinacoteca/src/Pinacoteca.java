public class Pinacoteca {
    private String nome;
    private Quadro[] vQuadri;
    private final int MAX_QUADRI;
    private final static int DEF_QUADRI = 100;
    private int num_quadri;

    public Pinacoteca(String nome, int max_quadri){
        this.nome = nome;
        if(max_quadri > 0)
            MAX_QUADRI = max_quadri;
        else
            MAX_QUADRI = DEF_QUADRI;
        num_quadri = 0;
        vQuadri = new Quadro[MAX_QUADRI];
    }

    /*
   metodo ADD
   - controllo che l'oggetto passato non sia nullo
   - controllo di non superare il numero MAX di elementi
   - incrementare il contatore
     */
    public void addQuadri(Quadro q){
        if(q != null){
            if(num_quadri < MAX_QUADRI){
                vQuadri[num_quadri] = q;
                num_quadri++;
            }
        }
    }
    public void setPrezzo(String titolo, int perc){
        int tro = -1;
        int k = 0;
        while (k < num_quadri && tro == -1){
            if(vQuadri[k].getTitolo().equals(titolo)){
                vQuadri[k].setValore(vQuadri[k].getValore() + vQuadri[k].getValore() / 100 * perc);
                tro = 1;
            } else {
                k++;
            }
        }
    }
    public float getValoreMedio(){
        float somma = 0;
        float media;
        for(int k = 0; k < num_quadri; k++){
            somma += vQuadri[k].getValore();
        }
        if(num_quadri != 0)
            media = somma / num_quadri;
        else
            media = 0;
        return media;
    }
    public String toString(){
        String str = "";
        for(int k = 0; k < num_quadri; k++){
            str += vQuadri[k].toString() + "\n";
        }
        return str  + " Valore Medio: " + getValoreMedio();
    }
}
