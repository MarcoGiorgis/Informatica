public class Test {
    public static void main(String[] args) {
        Frazione frazione = new Frazione();
        Frazione frazione1 = new Frazione('x', 10);
        Frazione frazione2 = new Frazione('-', 10, 5);
        frazione.equals(frazione2);
        frazione1.getValore();
        Calcolo calcolo = new Calcolo(Operazioni.SOMMA, 10);
        calcolo.add(frazione);
        calcolo.add(frazione1);
        calcolo.add(frazione2);
        System.out.println(calcolo.toString());
    }
}