import java.util.Vector;

public class VectorInteri {
    private Vector<Integer> vInteri;

    public VectorInteri(){
        vInteri = new Vector<Integer>();
    }

    public VectorInteri(String elementi){
        String[] elementiCorretti = elementi.split("\\|"); // //-> servono per la |
        vInteri = new Vector<Integer>();
        for(int k = 0; k < elementiCorretti.length; k++){
            try{
                vInteri.add(Integer.parseInt(elementiCorretti[k]));
            } catch (NumberFormatException e){
                throw new NumberFormatException("Elemento non valido: " + elementiCorretti[k]);
            }
        }
    }

    public VectorInteri(int dim) {
        if(dim > 0) {
            vInteri = new Vector<Integer>();
            for(int k = 0; k < dim; k++) {
                vInteri.add(0);
            }
        }
        else {
            vInteri = new Vector<Integer>();
            vInteri.add(0);
        }
    }

    public int getDim(){
        return vInteri.size();
    }

    public void add(int elemento) {
        vInteri.add(elemento);
    }

    public int getNumeroMinimo() {
        int min = vInteri.get(0);
        if (vInteri.size() > 0) {
            for (int k = 1; k < vInteri.size(); k++) {
                if (vInteri.get(k) < min)
                    min = vInteri.get(k);
            }
        } else {
            throw new ErroreVettoreVuoto();
        }
        return min;
    }
    public int cercaPosizioneElementoArray(int elemento) throws ErroreElementoInesistente {
        int tro = -1;
        int k = 0;
        while (k < vInteri.size() && tro == -1) {
            if (vInteri.get(k) == elemento)
                tro = k;
            else
                k++;
        }
        if (tro != -1)
            return tro;
        else
            throw new ErroreElementoInesistente();
    }

    public void eliminaPrimaOccorrenza(int elemento) throws ErroreElementoInesistente {
        int pos = cercaPosizioneElementoArray(elemento);
        vInteri.removeElementAt(pos);
    }
    public void elimina(int elemento) throws ErroreElementoInesistente{
        if (!vInteri.removeElement(elemento)){
            throw new ErroreElementoInesistente();
        }
    }

    public String toString() {
        String str = "";
        for (int k: vInteri){
            str += k + "|";
        }
        return str;
    }
}
