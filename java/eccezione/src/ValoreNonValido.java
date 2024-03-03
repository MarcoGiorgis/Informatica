import java.io.IOException;

public class ValoreNonValido extends IOException { //eccezzione controllata
    public ValoreNonValido(String s){
        super(s); //s = messaggio di errore
    }
    public ValoreNonValido(){
        super("Valore non valido");
    }
}
