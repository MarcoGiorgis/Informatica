import java.util.Vector;

public class Sito {
    private String nome;
    private String nazione;
    private Vector<Pozzo> vPozzi;
    private int progPozzi;
    private Responsabile responsabile;

    public Sito(String nome, String nazione, Responsabile responsabile) {
        this.nome = nome;
        this.nazione = nazione;
        this.responsabile = responsabile;
        progPozzi = 1;
        vPozzi = new Vector<Pozzo>();
    }
    private abstract class Pozzo{
        private int codice;
        private boolean attivo;
        private int capacitaEstrattiva; //libri

        public Pozzo(int capacitaEstrattiva) throws ErroreValoreNonValido {
            if(capacitaEstrattiva > 0)
                this.capacitaEstrattiva = capacitaEstrattiva;
            else
                throw new ErroreValoreNonValido("Capacità estrattiva deve essere positiva");
            attivo = false;
            codice = progPozzi++;
        }

        public int getCodice() {
            return codice;
        }

        public boolean isAttivo() {
            return attivo;
        }

        public int getCapacitaEstrattiva() {
            return capacitaEstrattiva;
        }

        public void setCapacitaEstrattiva(int capacitaEstrattiva) throws ErroreValoreNonValido {
            if(capacitaEstrattiva > 0)
                this.capacitaEstrattiva = capacitaEstrattiva;
            else
                throw new ErroreValoreNonValido("Capacità estrattiva deve essere positiva");
        }

        public void switchStato(){
            attivo = !attivo;
        }

        @Override
        public String toString() {
            return "Pozzo{" +
                    "codice=" + codice +
                    ", attivo=" + attivo +
                    ", capacitaEstrattiva=" + capacitaEstrattiva +
                    '}';
        }
    }
    private class Terrestre extends Pozzo{
        private Tipi tipoTerra;

        public Terrestre(int capacitaEstrattiva, Tipi tipoTerra) throws ErroreValoreNonValido {
            super(capacitaEstrattiva);
            this.tipoTerra = tipoTerra;
        }
    }
}
