public class Barca {
    private String nome;
    private String nazionalita;
    private String proprietario;
    private final double LUNG;
    private final double LARG;

    public Barca(String nome, String nazionalita, String proprietario, double larghezza, double lunghezza) {
        this.nome = nome;
        this.nazionalita = nazionalita;
        this.proprietario = proprietario;
        LUNG = larghezza;
        LARG = lunghezza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNazionalità() {
        return nazionalita;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }


    public double getLUNG() {
        return LUNG;
    }

    public double getLARG() {
        return LARG;
    }

    public String toString(){
        return " Nome: " + nome + " Nazionalità: " + nazionalita + " Proprietario: " + proprietario;
    }
}
