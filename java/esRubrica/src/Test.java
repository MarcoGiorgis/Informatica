public class Test {
    public static void main(String[] args) {
        Utenza utenza = new Utenza("Marco", "Giorgis", "3666616216", "abc");
        Utenza utenza1 = new Utenza("Francesco", "Giorgis", "000000000");

        AgendaTelefonica agendaTelefonica = new AgendaTelefonica(10);
        agendaTelefonica.inserimentoUtenza(utenza);
        agendaTelefonica.inserimentoUtenza(utenza1);
        System.out.println("Ricerca utenza: ");
        System.out.println(agendaTelefonica.ricercaUtenza("Francesco").toString());
        agendaTelefonica.modificaUtenza("Francesco");
        System.out.println(agendaTelefonica.toString());
    }
}