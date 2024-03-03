public class Test {
    public static void main(String[] args) {
        Veicolo veicolo = new Veicolo(1, "aa000aa", "audi", "r8gt");
        Veicolo veicolo1 = new Veicolo(2, "bb000bb", "bmw", "m4");

        Veicolo veicolo2 = new Veicolo(3,"cc000cc", "opel", "mokka");
        Veicolo veicolo3 = new Veicolo(4, "dd000dd", "fiat", "punto");

        Responsabile responsabile = new Responsabile("Marco", "Giorgis", "02/04/06", "GRGMRC06D02D205F");
        Autonoleggio autonoleggio = new Autonoleggio("a", 12025, 10, responsabile);

        Responsabile responsabile1 = new Responsabile("Francesco", "Rossi", "00/00/00", "XXXXXXXXXXXXXXXX");
        Autonoleggio autonoleggio1 = new Autonoleggio("b", 12022, 20, responsabile1);

        autonoleggio.aggiungiVeicolo(veicolo);
        autonoleggio.aggiungiVeicolo(veicolo1);

        autonoleggio1.aggiungiVeicolo(veicolo2);
        autonoleggio1.aggiungiVeicolo(veicolo3);

        System.out.println(autonoleggio.trovaVeicolo("bb000bb").toString());

        System.out.println(autonoleggio1.trovaVeicolo("cc000cc").toString());

        System.out.println(autonoleggio.toString());

        System.out.println(autonoleggio1.toString());
    }
}