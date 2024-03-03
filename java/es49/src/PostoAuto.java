public class PostoAuto {
    private int numero;
    private Auto occupatoDa;
    private int indice;

    public PostoAuto(int numero) {
        this.numero = numero;
        this.indice++;
    }
    public boolean isOccupato(){
        return occupatoDa != null;
    }

    public void autoIn(Auto a){
        if(!isOccupato()){
            this.occupatoDa = a;
        }
    }

    public void autoOut(){
        this.occupatoDa = null;
    }

    public int getNumero() {
        return numero;
    }

    public Auto getOccupatoDa() {
        return occupatoDa;
    }

    public int getIndice(){
        return indice;
    }

    @Override
    public String toString() {
        return "PostoAuto: " + " numero " + numero + " occupato da: " + occupatoDa;
    }
    public class Auto {
        private double altezza;
        private double oraIngresso;
        private double oraAttuale;
        private int biglietto;
        private int pagamento;
        private String targa;
        private PostoAuto siTrova;

        public Auto(double altezza, String targa) {
            this.altezza = altezza;
            this.targa = targa;
        }

        public void parcheggia(PostoAuto posto, double orario){
            oraIngresso = orario;
            siTrova = posto;
        }

        public double getAltezza() {
            return altezza;
        }

        public double getOraIngresso() {
            return oraIngresso;
        }

        public int getBiglietto() {
            return biglietto;
        }

        public String getTarga() {
            return targa;
        }

        public PostoAuto getSiTrova() {
            return siTrova;
        }

        public double getImpDaPag(double oraAttuale, double oraIngresso, double pagamento){
            return (oraAttuale - oraIngresso) * pagamento;
        }

        @Override
        public String toString() {
            return "Auto: " + " altezza: " + altezza + " oraIngresso " + oraIngresso +
                    " biglietto " + biglietto + " targa " + targa + " si trova nel posto: " + siTrova;
        }
    }
}
