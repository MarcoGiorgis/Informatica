public class Canzone {
    private String titolo;
    private String autore;
    private int durataSec;

    public Canzone(String titolo, String autore, int durataSec) {
        this.titolo = titolo;
        this.autore = autore;
        this.durataSec = durataSec;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }
    public String toString(){
        return "Titolo: " + titolo + " Autore: " + autore + " Durata Secondi: " + durataSec;
    }
}
