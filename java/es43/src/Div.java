public class Div implements Operazione{
    private int x;
    private int y;

    public Div(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getRisultato() {
        return x / y;
    }
}
