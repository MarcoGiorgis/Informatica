public class Libro {
    private int numPagine;

    public Libro(int numPagine) {
        if(numPagine > 0)
            this.numPagine = numPagine;
        else
            this.numPagine = 1;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public void pageMessage(){
        System.out.println(numPagine);
    }

    @Override
    public String toString() {
        return "Il libro ha " + numPagine + " pagine";
    }
}
