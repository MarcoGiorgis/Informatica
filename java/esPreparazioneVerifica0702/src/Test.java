public class Test {
    public static void main(String[] args) {
        SuccursaleBiblioteca s1 = new SuccursaleBiblioteca("giorgis", "via roma");

        s1.addScaffale(TipoArticolo.LIBRO, 25);
        s1.addScaffale(TipoArticolo.DVD, 25);

        Libro libro = new Libro("ciao", 20, 40, "io");
        DVD dvd = new DVD("ciao1", 40, 60, "luca");

        Utente utente = new Utente("grg", "marco", "girogis");

        s1.addUtente(utente);

    }
}