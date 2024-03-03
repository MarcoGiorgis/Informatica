public class Test {
    public static void main(String[] args) {
        Dado dado1 = new Dado(8);
        Dado dado2 = new Dado();
        //dado1.lancioDado();
        //dado2.lancioDado();
        Secchiello secchiello = new Secchiello(10);
        secchiello.add(dado1);
        secchiello.add(dado2);
        secchiello.lancio();

        System.out.println("Dado 1" + dado1.toString());
        System.out.println("Dado 2" + dado2.toString());
        System.out.println(secchiello.toString());
    }
}