public class Mul implements Operazione{
    private int x;
    private int y;

    public Mul(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getRisultato() {
        return x * y;
    }
}

