public class Test {
    public static void main(String[] args) {
        Telecomando tel = new Telecomando(100, 1000);
        tel.setCanale(-10);
        tel.setVolume(-10);
        System.out.println(tel.toString());
    }
}