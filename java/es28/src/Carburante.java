public class Carburante {
    private float prezzo;
    private String tipo;
    private final static String DEF_TIPO = "benzina"; //static condiviso con tutte le classi
    private final static float DEF_PREZZO = 1.5f;
    private TipoCarburante tipoC;
    private final static TipoCarburante DEF_TIPO_C = TipoCarburante.BENZINA;
    private final static String[] POS_TIPI = {"benzina", "diesel", "GPL", "metano"}; //vettore di stringhe

    public Carburante(){
        this.prezzo = DEF_PREZZO;
        this.tipo = DEF_TIPO;
    }
    private int isTipo(String tipo){
        int tro = -1;
        int k = 0;
        while (k < POS_TIPI.length && tro == -1){
            if(tipo.equals(POS_TIPI[k]));{
                tro = k;
            }
            k++;
        }
        return tro;
    }
    public Carburante(int prezzo, String tipo){
        if(isTipo(tipo) != -1)
            this.tipo = tipo;
        else
            this.tipo = DEF_TIPO;
        if(prezzo >= 0)
            this.prezzo = prezzo;
        else
            this.prezzo = DEF_PREZZO;
    }

    public void setPrezzo(float prezzo) {
        if(prezzo >= 0)
            this.prezzo = prezzo;
    }

    public void setTipo(String tipo){
        if(this.tipo != null && isTipo(tipo) != -1)
            this.tipo = tipo;
        else

            this.tipo = DEF_TIPO;
    }
    public float getPrezzo(){
        return prezzo;
    }
    public String getTipo(){
        return tipo;
    }
    public boolean equals(Carburante c){
        return this.prezzo == c.getPrezzo();
    }
    public String toString(){
        return "tipo: " + getTipo() + " prezzo: " + getPrezzo();
    }
}
