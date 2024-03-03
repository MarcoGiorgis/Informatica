import java.io.IOException;

public class ValoreNonValidoNONcontrollata extends RuntimeException { //eccezzione NON controllata
    public ValoreNonValidoNONcontrollata(String s){
        super(s); //s = messaggio di errore
    }
    public ValoreNonValidoNONcontrollata(){
        super("Valore non valido");
    }
}
