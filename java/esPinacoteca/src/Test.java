public class Test {
    public static void main(String[] args) {
        Quadro quadro = new Quadro("Gioconda", "Giorgis", Tecniche.CARTONCINO, 10);
        Quadro quadro1 = new Quadro("Gianni", "Sciolla", Tecniche.ACQUERELLO, 20);
        quadro.isParagonabile(quadro1);

        Pinacoteca pinacoteca = new Pinacoteca("da Bramardi", 100);

        pinacoteca.addQuadri(quadro);
        pinacoteca.addQuadri(quadro1);
        pinacoteca.setPrezzo("Gianni", 20);
        System.out.println(pinacoteca.toString());
    }
}