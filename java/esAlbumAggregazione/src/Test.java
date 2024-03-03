public class Test {
    public static void main(String[] args) {
        Canzone c1 = new Canzone("Bramardi", "io", 250);
        Canzone c2 = new Canzone("Prandi", "oi", 240);
        Album a1 = new Album("Ciao", c1);
        a1.add(c2);
        //System.out.println(a1.toString());
        System.out.println(a1); //sinonimo di toString
    }
}