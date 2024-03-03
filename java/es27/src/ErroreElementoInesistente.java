import java.io.IOException;

public class ErroreElementoInesistente extends IOException {
    public ErroreElementoInesistente() {
        super("Errore Elemento Inesistente");
    }

    public ErroreElementoInesistente(String message) {
        super(message);
    }
}
