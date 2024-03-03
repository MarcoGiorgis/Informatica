import java.util.Vector;

public class AlbumComp {
    private String titolo;
    private Vector<CanzoneComp> vBrani;

    public AlbumComp(String titolo, String titoloCanzone, String autore, int durataSec) {
        this.titolo = titolo;
        this.vBrani = new Vector<CanzoneComp>();
        add(titoloCanzone, autore, durataSec);
    }
    public void add(String titolo, String autore, int durataSecondi){
        this.vBrani.add(new CanzoneComp(titolo, autore, durataSecondi));
    }
    public String toString(){
        String str = "";
        for(int k = 0; k < vBrani.size(); k++){
            str += vBrani.get(k).toString() + "\n";
        }
        return str;
    }
    public class CanzoneComp {
        private String titolo;
        private String autore;
        private int durataSec;

        public CanzoneComp(String titolo, String autore, int durataSec) {
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
}
