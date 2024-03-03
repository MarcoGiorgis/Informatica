import java.util.Vector;

public class Garage {
    private String nome;
    private Vector<Piano> vPiani;
    private String costoOrario;
    private char progLettera;

    public Garage(String nome, String costoOrario, int numPiani) {
        this.nome = nome;
        this.costoOrario = costoOrario;
        vPiani = new Vector<Piano>();
    }

    public void addPiano(Piano p){
        if(p != null){
            vPiani.add(p);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCostoOrario() {
        return costoOrario;
    }

    public String getPostiLiberi() { //controllare se isOccupato == true o false
        String str = "";
        for (Piano p: vPiani) {
            str += p.getPostiLiberi();
        }
        return str;
    }

    public void autoIn(){

    }
    public double getImpDaPag(){ //calcolare importo di ogni posto

    }

    public void setCostoOrario(String costoOrario) {
        this.costoOrario = costoOrario;
    }

    public String toString(){
        return null;
    }
}
