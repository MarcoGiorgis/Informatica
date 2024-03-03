import java.io.IOException;

public class ErroreVettorePieno extends IOException {
    public ErroreVettorePieno() {
        super("Vettore Pieno");
    }

    public ErroreVettorePieno(String message) {
        super(message);
    }
}
