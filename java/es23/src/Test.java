public class Test {
    public static void main(String[] args) {
        Giocatore giocatore = new Giocatore("Marco", 17);
        Giocatore giocatore1 = new Giocatore("Francesco", 20, 100);
        System.out.println(giocatore.toString());
        System.out.println(giocatore1.toString());
    }
}