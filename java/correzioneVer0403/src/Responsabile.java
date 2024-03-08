public class Responsabile {
    private String nome;
    private String cognome;
    private String telefono;
    private int anni;

    public Responsabile(String nome, String cognome, String telefono, int anni) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.anni = anni;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getAnni() {
        return anni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setAnni(int anni) {
        this.anni = anni;
    }
}

