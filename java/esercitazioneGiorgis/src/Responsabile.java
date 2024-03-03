public class Responsabile {
    private String nome;
    private String cognome;
    private String dataNascita;
    private String codiceFiscale;

    public Responsabile(String nome, String cognome, String dataNascita, String codiceFiscale){
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        if(codiceFiscale.length() == 16){
            this.codiceFiscale = codiceFiscale;
        }else{
            this.codiceFiscale = "XXXXXXXXXXXXXXXX";
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        if(codiceFiscale.length() == 16) {
            this.codiceFiscale = codiceFiscale;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String toString() {
        return "Nome: " + nome + " Cognome: " + cognome + " Data di nascita: " + dataNascita + " Codice fiscale: " + codiceFiscale;
    }
}
