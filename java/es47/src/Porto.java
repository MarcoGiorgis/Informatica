import javax.sound.sampled.Port;
import java.util.Vector;

public class Porto {
    private String nome;
    private String localita;
    private int progMolo = 0;
    private Vector<Molo> vMoli;

    public Porto(String nome, String localita, Molo m) {
        this.nome = nome;
        this.localita = localita;
        vMoli = new Vector<Molo>();
        vMoli.add(m);
    }

    public String getNome() {
        return nome;
    }

    public String getLocalita() {
        return localita;
    }

    public void add(Molo m){
        if(m != null){
            vMoli.add(m);
        }
    }

    public void passatoUnGiorno(){
        for(int k = 0; k < vMoli.size(); k++){
            vMoli.get(k).passatoUnGiorno();
        }
    }

    public String getPostiLiberi(Barca b){
        String str = "";
        for(Molo m: vMoli){
            if(m.getMAXLARG() >= b.getLARG() && m.getMAXlUNG() >= b.getLUNG()){
                str += m.getPostiLiberi();
            }
        }
        return str;
    }

    public void BarcaIn(Barca b, int indiceMolo, int indicePosto, int numGiorni) throws ValoreNonValido {
        Molo tro = null;
        int k = 0;
        while (k < vMoli.size() && tro == null){
            if(vMoli.get(k).getIndice() == indiceMolo){
                tro = vMoli.get(k); //restituisce il molo
            }
            k++;
        }
        if(tro != null) {
            Molo.PostoBarca troPosto = null;
            int j = 0;
            while (j < tro.getvPostiBarca().size() && troPosto == null) {
                if (tro.getvPostiBarca().get(j).getIndice() == indicePosto) {
                    troPosto = tro.getvPostiBarca().get(j);
                    if (!troPosto.isOccupato()) {
                        troPosto.barcaIn(b, numGiorni);
                    } else {
                        throw new ValoreNonValido();
                    }
                }
                j++;
            }
            if(troPosto == null){
                throw new ValoreNonValido();
            }
        }
        else {
            throw new ValoreNonValido();
        }
    }

    public String toString(){
        String str = "";
        for(int k = 0; k < vMoli.size(); k++){
            str += vMoli.get(k).toString() + " ";
        }
        return "PORTO: " + " Nome: " + nome + " Località: " + localita + str;
    }
}
