public class Test {
    public static void main(String[] args) {
        Libro l1 = new Libro(10);
        l1.pageMessage();
        System.out.println(l1.toString());

        Vocabolario v1 = new Vocabolario(10,300);
        v1.definitionMessage();
        System.out.println(v1.toString());
    }
}