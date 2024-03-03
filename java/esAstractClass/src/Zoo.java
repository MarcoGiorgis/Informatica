public class Zoo {
    private String nome;
    private final int DIM;
    private static final int DEF_DIM = 10;
    private int numAnimali;
    private Animale[] gabbie;

    public Zoo(String nome, int dim){
        this.nome = nome;
        if(dim > 0)
            DIM = dim;
        else
            DIM = DEF_DIM;
        gabbie = new Animale[DIM];
        numAnimali = 0;
    }
    public void add(Animale a){
        if(a != null){
            if(numAnimali < DIM){
                gabbie[numAnimali] = a;
                numAnimali++;
            }
        }
    }
    public void presentatevi(){
        for(int k = 0; k < numAnimali; k++){
            gabbie[k].miPresento();
        }
    }
}
