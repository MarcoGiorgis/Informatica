public class DVD extends Articolo{
    private double durata;
    private String regista;


    public DVD(String titolo, double valore, double durata, String regista) {
        super(titolo, valore);
        this.durata = durata;
        this.regista = regista;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "durata=" + durata +
                ", regista='" + regista + '\'' +
                "} " + super.toString();
    }
}
