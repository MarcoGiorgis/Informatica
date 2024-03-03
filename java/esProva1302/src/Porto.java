public class Porto {
    private static final int MAX_POSTI = 100;
    private PostoBarca[] vPostiBarca;
    private int progPosto;
    private double prezzoMetro;

    public Porto(double prezzoMetro) {
        this.prezzoMetro = prezzoMetro;
        vPostiBarca = new PostoBarca[MAX_POSTI];
        progPosto = 0;
    }

    public int getProgPosto() {
        return progPosto;
    }

    public void addPostoBarca(double dataInzio, double dataFine, Barca occupante){
        if(progPosto < MAX_POSTI){
            vPostiBarca[progPosto] = new PostoBarca(dataInzio, dataFine, occupante);
            progPosto++;
        }
    }
    /*
    public String affituario(PostoBarca p){
        return p.getOccupante().getNome();
    }
    */
    public String affituario(int n){
        if(n >= 0 && n < progPosto){
            return vPostiBarca[n].getOccupante().getNome();
        } else {
            return null; //eccezione
        }
    }
    public double getPrezzo(int n, double prezzoMetro){
        return vPostiBarca[n].getOccupante().getLarg() * vPostiBarca[n].getOccupante().getLung() * prezzoMetro;
    }
    public boolean controlla(int n){
        return vPostiBarca[n].isOccupato();
    }
    public void affittaPosto(int n, Barca b){
        if(vPostiBarca[n].getOccupante() != null){
            //eccezione
        }
        vPostiBarca[n].setOccupante(b);
        vPostiBarca[n].setOccupato(true);
    }
    public double liberaPosto(int n){
        if(vPostiBarca[n].getOccupante() == null){
            //eccezione
        }
        double prezzoTer = vPostiBarca[n].getOccupante().getLarg() * vPostiBarca[n].getOccupante().getLung() * prezzoMetro;
        vPostiBarca[n].setOccupato(null);
        return (vPostiBarca[n].getDataFIne() - vPostiBarca[n].getDataInizio()) * prezzoTer;
    }
    private class PostoBarca{
        private double dataInizio;
        private double dataFIne;
        private Barca occupante;
        private boolean isOccupato;

        public PostoBarca(double dataInizio, double dataFIne, Barca occupante) {
            this.dataInizio = dataInizio;
            this.dataFIne = dataFIne;
            this.occupante = occupante;
        }

        public double getDataInizio() {
            return dataInizio;
        }

        public double getDataFIne() {
            return dataFIne;
        }

        public Barca getOccupante() {
            return occupante;
        }

        public boolean isOccupato() {
            return isOccupato;
        }

        public void setOccupante(Barca occupante) {
            this.occupante = occupante;
        }

        public void setOccupato(Boolean occupato) {
            isOccupato = occupato;
        }

        @Override
        public String toString() {
            return "PostoBarca{" +
                    "dataInizio=" + dataInizio +
                    ", dataFIne=" + dataFIne +
                    ", occupante=" + occupante +
                    ", isOccupato=" + isOccupato +
                    '}';
        }
    }
}
