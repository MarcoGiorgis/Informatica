
public class Dado {
    private final int NUM_FACCE;
    private int num_uscito;
    private static int FACCE_DEFAULT = 6;

    public Dado (int num_facce){
        if(num_facce < 0)
            NUM_FACCE = FACCE_DEFAULT;
        else
            NUM_FACCE = num_facce;
    }
    public Dado(){
        NUM_FACCE = FACCE_DEFAULT;
    }
    public void lancioDado(){
        this.num_uscito = (int) (Math.random() * (NUM_FACCE) + 1);
    }
    public int getLancio(){
        return num_uscito;
    }
    public String toString(){
        return "[" + getLancio() + "]";
    }
}
