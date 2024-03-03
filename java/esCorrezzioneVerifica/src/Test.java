public class Test {
    public static void main(String[] args) {
        Libro l1 = new Libro("ciao", "giorgis", Generi.HORROR, 10, 20);
        Libro l2 = new Libro("ciao2", "giorgis2", Generi.GIALLO, 10, 30);
        if(l1.compareTo(l2) == 1)
            System.out.println(l1.getTitolo() + " è più costoso di: " + l2.getTitolo());
        else if (l1.compareTo(l2) == 0)
            System.out.println(l1.getTitolo() + l2.getTitolo() + " hanno lo stesso prezzo");
            else
            System.out.println(l1.getTitolo() + " è meno costoso di: " + l2.getTitolo());
        Libreria libreria = new Libreria("a", "cuneo", 10);
        libreria.add(l1);
        libreria.add(l2);
        libreria.cambiaPrezzo("giorgis", 20, 'a');
        libreria.Statistica();
        System.out.println(libreria.toString());

        LibreriaVector libreriaVector = new LibreriaVector("a", "cuneo");
        libreriaVector.add(l1);
        libreriaVector.add(l2);
        System.out.println(libreriaVector.toString());
        libreriaVector.Statistica2();
    }
}