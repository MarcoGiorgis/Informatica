import java.util.Vector;

public class SuccursaleBiblioteca {
    private String nome;
    private String indirizzo;
    private int progScaffale;
    private Vector<Scaffale> vScaffali;
    private Vector<Utente> vUtenti;

    public SuccursaleBiblioteca(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        progScaffale = 0;
        vScaffali = new Vector<>();
        vUtenti = new Vector<>();

    }

    public void addScaffale(TipoArticolo tipo, int max_articoli) {
        vScaffali.add(new Scaffale(tipo, max_articoli));
    }

    public void addUtente(Utente u) {
        if (u != null && ricercaTramiteCodFiscale(u.getCodiceFiscale()) != null) {
            vUtenti.add(u);
        }
    }


    public double getValoreTotale() {
        double sommaTotale = 0;
        for (Scaffale s : vScaffali) {
            sommaTotale += s.getValoreScaffale();
        }
        return sommaTotale;
    }

    private Articolo ricercaArtId(int id) {
        int j = 0;
        Articolo aId = null;
        while (j < vScaffali.size() && aId == null) {
            aId = vScaffali.get(j).cercaArticoloID(id);
            j++;
        }
        if (aId != null) {
            return aId;
        } else {
            //eccezione
            return null;
        }
    }


    private Utente ricercaTramiteCodFiscale(String codiceFiscale) throws ErroreUtenteGiaPresente {
        int k = 0;
        Utente tro = null;
        while (k < vUtenti.size() && tro == null) {
            if (codiceFiscale.equals(vUtenti.get(k).getCodiceFiscale())) {
                tro = vUtenti.get(k);
            }
            k++;
        }
        if (tro != null) {
            return tro;
        } else {
            throw new ErroreUtenteGiaPresente();
        }
    }

    public void prestitoId(String codiceFIscale, int id) {
        //GESTIONE ECCEZIONI: SE NON C'è L'ARTICOLO O L'UTENTE
        Articolo aId = ricercaArtId(id);
        Utente tro = ricercaTramiteCodFiscale(codiceFIscale);
        aId.setInPrestitoA(tro);
    }

    public void liberaId(int id) {
        Articolo aId = ricercaArtId(id);
        aId.setInPrestitoA(null);
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < vScaffali.size(); i++) {
            s += vScaffali.get(i).toString();
        }
        return "nome: " + nome + " indirizzo: " + indirizzo + s;
    }

    public boolean addArticolo(Articolo a) {
        boolean aggiunto = false;
        int x = vScaffali.size() - 1;
        if (vScaffali.get(x).getnArticoli() < vScaffali.get(x).getMAX_ARTICOLI()) {
            if ((a instanceof DVD && vScaffali.get(x).getTipo() == TipoArticolo.DVD) || (a instanceof Libro && vScaffali.get(x).getTipo() == TipoArticolo.LIBRO)) {
                vScaffali.get(x).vArticoli[vScaffali.get(x).nArticoli] = a;
                vScaffali.get(x).setnArticoli(vScaffali.get(x).getnArticoli() + 1);
                aggiunto = true;
            }
        }
        return aggiunto;
    }

    public class Scaffale {
        private int numero;
        private TipoArticolo tipo;
        private final int MAX_ARTICOLI;
        private static final int DEF_ARTICOLI = 10;
        private Articolo vArticoli[];
        private int nArticoli;

        public int getMAX_ARTICOLI() {
            return MAX_ARTICOLI;
        }

        public void setnArticoli(int nArticoli) {
            this.nArticoli = nArticoli;
        }

        public TipoArticolo getTipo() {
            return tipo;
        }

        public int getnArticoli() {
            return nArticoli;
        }

        public Scaffale(TipoArticolo tipo, int max_articoli) {
            this.numero = progScaffale++;
            this.tipo = tipo;
            if (max_articoli > 0)
                MAX_ARTICOLI = max_articoli;
            else
                MAX_ARTICOLI = DEF_ARTICOLI;
            vArticoli = new Articolo[MAX_ARTICOLI];
            nArticoli = 0;
        }


        public Vector<Articolo> cercaArticoloTitolo(String titolo) {
            int k = 0;
            Vector<Articolo> vArticoliCercati = null;
            while (k < nArticoli) {
                if (titolo.equals(vArticoli[k].getTitolo())) {
                    vArticoliCercati.add(vArticoli[k]);
                }
                k++;
            }
            if (vArticoliCercati != null) {
                return vArticoliCercati;
            } else {
                return null; //eccezione
            }
        }

        public Articolo cercaArticoloID(int id) {
            int k = 0;
            Articolo tro = null;
            while (k < nArticoli && tro != null) {
                if (id == vArticoli[k].getIdArticolo()) {
                    tro = vArticoli[k];
                }
                k++;
            }
            if (tro != null)
                return tro;
            else
                return null; //eccezione
        }

        public double getValoreScaffale() {
            double tot = 0;
            for (int i = 0; i < nArticoli; i++) {
                tot += vArticoli[nArticoli].getValore();
            }
            return tot;
        }

        public Articolo[] getvArticoli() {
            return vArticoli;
        }

        public String toString() {
            String s = "";
            for (int i = 0; i < nArticoli; i++) {
                s += vArticoli[i].toString();
            }
            return s + " numero: " + nArticoli + " tipo: " + tipo;
        }
    }
}
