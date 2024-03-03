public class Persona {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private final static String DEF_CF = "AAAAAAAAAAAAAAAA";

    public Persona(String nome, String cognome, String codiceFiscale){
        this.nome = nome;
        this.cognome = cognome;
        if(codiceFiscale.length() == 16)
            this.codiceFiscale = codiceFiscale;
        else
            this.codiceFiscale = DEF_CF;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        if(codiceFiscale.length() == 16)
            this.codiceFiscale = codiceFiscale;
        else
            this.codiceFiscale = DEF_CF;
    }
    public void parla(){
        System.out.println("ciao");
    }
    public String toString(){
        return "Nome: " + nome + " Cognome: " + cognome + " Codice fiscale: " + codiceFiscale;
    }
}
