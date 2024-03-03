public class Studente extends Persona{
    private String matricola;
    private String universita;

    public Studente(String nome, String cognome, String codiceFiscale, String matricola, String universita){
        super(nome, cognome, codiceFiscale);
        this.matricola = matricola;
        this.universita = universita;
    }

    public String getMatricola() {
        return matricola;
    }

    public String getUniversita() {
        return universita;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public void setUniversita(String universita) {
        this.universita = universita;
    }

    @Override //sovrascrive al metodo superiore
    public void parla() {
        System.out.println("ao");
    }

    @Override
    public String toString() {
        return super.toString() + " Matricola: " + matricola + " Università: " + universita;
    }
}
