public class Veicolo {
    private int codice;
    private String targa;
    private String marca;
    private String modello;
    private final static String DEFAULT_TARGA = "AA000AA";

    public Veicolo(int codice,String targa, String marca, String modello){
        this.codice = codice;
        if(targa.length() == 7)
            this.targa = targa;
        else
            this.targa = DEFAULT_TARGA;
        this.marca = marca;
        this.modello = modello;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public int getCodice() {
        return codice;
    }
    public String getTarga() {
        return targa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public String toString() {
        return "Codice: " + codice + " Targa: " + targa + " Marca: " + marca + " Modello: " + modello;
    }
}
