public class Concessionaria {
    private final int MAX_AUTO;
    private int num_auto;
    private Auto[] vAuto;
    private String nome;

    public Concessionaria(String nome, int max_auto){
        this.nome = nome;
        if(max_auto < 1)
            MAX_AUTO = 1;
        else
            MAX_AUTO= max_auto;
        num_auto = 0;
        vAuto = new Auto[MAX_AUTO];
    }
    public void add(Auto auto) {
        if (auto != null) {
            if (num_auto < MAX_AUTO) {
                vAuto[num_auto] = auto;
                num_auto++;
            }
        }
    }
    public int getSommaPrezzi(){
        int somma = 0;
        for(int k = 0; k < num_auto; k++){
            somma = somma + vAuto[k].getPrezzo();
        }
        return somma;
    }
    public void getColoriAutoModello(String modello){
        System.out.println("Colori disponibili per il modello " + modello + "':");
        for (Auto auto : vAuto) {
            if(auto != null) {
                if (auto.getModello().equalsIgnoreCase(modello)) {
                    System.out.println(auto.getColore());
                }
            }
        }
    }
    public String toString(){
        String str = "";
        for(int k = 0; k < num_auto; k++){
            str += vAuto[k].toString() + "\n";
        }
        return str;
    }
}
