public class Main {
    public static void main(String[] args) {
        int s = 0;
        System.out.println("vettori");
        int vett[] = new int[5]; //vengono già inizializzati a 0
        System.out.println("for classico");
        for(int k = 0; k < vett.length; k++){ //vett.length -> calcolo dimensione
            vett[k]++;
            System.out.println(vett[k] + "");
        }
        System.out.println("\n for each");
        for(int el: vett) { //el = variabile che contiene il valore dei singoli elementi
            el++;           //non cambia il vettore
            System.out.println(el + "");
            s = s + el;
        }
        System.out.println("somma = " + s);
    }
}