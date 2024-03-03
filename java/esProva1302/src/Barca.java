public class Barca {
    private String codiceFiscale;
    private String nomeProprietario;
    private String matricola;
    private String nome;
    private double lung;
    private double larg;
    private int anno;

    public Barca(String codiceFiscale, String nomeProprietario, String matricola, String nome, double lung, double larg, int anno) {
        this.codiceFiscale = codiceFiscale;
        this.nomeProprietario = nomeProprietario;
        this.matricola = matricola;
        this.nome = nome;
        this.lung = lung;
        this.larg = larg;
        this.anno = anno;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public String getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public double getLung() {
        return lung;
    }

    public double getLarg() {
        return larg;
    }

    public int getAnno() {
        return anno;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    @Override
    public String toString() {
        return "Barca{" +
                "codiceFiscale='" + codiceFiscale + '\'' +
                ", nomeProprietario='" + nomeProprietario + '\'' +
                ", matricola='" + matricola + '\'' +
                ", nome='" + nome + '\'' +
                ", lung=" + lung +
                ", larg=" + larg +
                ", anno=" + anno +
                '}';
    }
}
