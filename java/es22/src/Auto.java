public class Auto {
    private String modello;
    private String colore;
    private int prezzo;

    public Auto(String modello, String colore, int prezzo){
        this.modello = modello;
        setColore(colore);
        this.prezzo = prezzo;
    }
    public void setColore(String colore){
        if(colore.equals("rosso") || colore.equals("nero") || colore.equals("grigio") || colore.equals("bianco"))
            this.colore = colore;
        else
            this.colore = "grigio";
    }
    public String getModello(){
        return modello;
    }
    public String getColore(){
        return colore;
    }
    public int getPrezzo(){
        return prezzo;
    }
    public String toString(){
        return "modello: " + getModello() + " colore: " + getColore() + " prezzo: " + getPrezzo();
    }
}
