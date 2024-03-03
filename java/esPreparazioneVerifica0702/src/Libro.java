public class Libro extends Articolo{
    private int numeroPagine;
    private String autore;

    public Libro(String titolo, double valore, int numeroPagine, String autore) {
        super(titolo, valore);
        this.numeroPagine = numeroPagine;
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "numeroPagine=" + numeroPagine +
                ", autore='" + autore + '\'' +
                "} " + super.toString();
    }
}

