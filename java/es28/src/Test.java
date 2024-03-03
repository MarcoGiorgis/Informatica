public class Test {
    public static void main(String[] args) {
        Carburante pompa1 = new Carburante();
        Carburante pompa2 = new Carburante(10, "GPL");
        Distributore distributore = new Distributore("a", 12, 10);
        distributore.add(pompa1);
        distributore.add(pompa2);
        System.out.println(distributore.equals(pompa2));
        distributore.aumenta("benzina", 10);
        System.out.println(distributore.toString());
    }
}