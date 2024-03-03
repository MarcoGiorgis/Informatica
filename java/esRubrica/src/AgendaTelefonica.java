public class AgendaTelefonica {
    private final int MAX_UTENZE;
    private final static int DEFAULT_UTENZE = 5;
    private int num_utenze;
    private Utenza[] vUtenze;

    public AgendaTelefonica(int max_utenze){
        if(max_utenze > 0)
            MAX_UTENZE = max_utenze;
        else
            MAX_UTENZE = DEFAULT_UTENZE;
        num_utenze = 0;
        vUtenze = new Utenza[MAX_UTENZE];
    }

    public void inserimentoUtenza(Utenza utenza){
        if(utenza != null){
            if(num_utenze < MAX_UTENZE){
                vUtenze[num_utenze] = utenza;
                num_utenze++;
            }
        }
    }
    public Utenza ricercaUtenza(String nome){
        Utenza utenza = null;
        int tro = -1;
        int k = 0;
        while (k < num_utenze && tro == -1){
            if(vUtenze[k].getNome() == nome) {
                utenza = vUtenze[k];
                tro = 1;
            } else {
                k++;
            }
        }
        return utenza;
    }

    public void modificaUtenza(String nome) {
        int tro = -1;
        int k = 0;
        while (k < num_utenze && tro == -1) {
            if (vUtenze[k].getNome() == nome) {
                vUtenze[k].setNome("Luigi");
                vUtenze[k].setCognome("Prandi");
                vUtenze[k].setNumTelefono("0000000000");
                vUtenze[k].setEmail("abc@gmial.com");
                tro = 1;
            } else {
                k++;
            }
        }
    }
    public String toString(){
        String str = "";
        for(int k = 0; k < num_utenze; k++){
            str += vUtenze[k].toString() + "\n";
        }
        return "Utenze: \n" + str;
    }
}
