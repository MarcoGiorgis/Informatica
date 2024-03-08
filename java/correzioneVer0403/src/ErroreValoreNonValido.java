import java.io.IOException;

public class ErroreValoreNonValido extends IOException {
    public ErroreValoreNonValido() {
        super("Valore non valido");
    }

    public ErroreValoreNonValido(String message) {
        super(message);
    }
}
