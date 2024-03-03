public class ErroreUtenteGiaPresente extends RuntimeException{
    public ErroreUtenteGiaPresente() {
        super("errore");
    }

    public ErroreUtenteGiaPresente(String message) {
        super(message);
    }
}
