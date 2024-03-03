public class Test {
    public static void main(String[] args) {
        Giocatore giocatore = new Giocatore("Marco", 17);
        Giocatore giocatore1 = new Giocatore("Francesco", 20, 100);
        System.out.println(giocatore.toString());
        System.out.println(giocatore1.toString());
        Squadra squadra = new Squadra("Juve", 20, "Battitore");
        squadra.add(giocatore);
        squadra.add(giocatore1);
        squadra.setPunteggio("Battitore", 10);
        squadra.passatoAnno();
        squadra.toString();
    }
}