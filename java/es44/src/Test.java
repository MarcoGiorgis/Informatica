public class Test {
    public static void main(String[] args) {
        Alianti a1 = new Alianti("a1", 200);
        Alianti a2 = new Alianti("a2", 40);
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a1.eLoStesso(a2));
        System.out.println(a1.isSuperiore(a2));

        Motore m1 = new Motore("m1", 300);
        Motore m2 = new Motore("m2", 400);
        System.out.println(m1.toString());
        System.out.println(m2.toString());
        System.out.println(m1.eLoStesso(m2));
        System.out.println(m1.isSuperiore(m2));
    }
}