public class Test {
    public static void main(String[] args) {
        Punto punto1 = new Punto(0, 0);
        Punto punto2 = new Punto(0, 1);
        Punto punto3 = new Punto(1, 1);
        Punto punto4 = new Punto(1, 0);

        Figura quadrato = new Figura("Quadrato", 4);

        quadrato.add(punto1);
        quadrato.add(punto2);
        quadrato.add(punto3);
        quadrato.add(punto4);

        System.out.println(quadrato.toString());
        System.out.println("Perimetro: " + quadrato.calcolaPerimetro());
    }
}