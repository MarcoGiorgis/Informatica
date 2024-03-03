import java.util.Arrays;

public class VettoreInteri {
    private final int DIMENSIONE;
    private int[] vInteri;
    private int nInteri;
    private static final int DEF_DIM = 1;


    public VettoreInteri() {
        DIMENSIONE = 1;
        vInteri = new int[DIMENSIONE];
        nInteri = 0;
    }

    public VettoreInteri(int dimensione) {
        if (dimensione > 0)
            DIMENSIONE = dimensione;
        else
            DIMENSIONE = DEF_DIM;
        vInteri = new int[DIMENSIONE];
        nInteri = 0;
    }
    public VettoreInteri(String elementi) throws NumberFormatException{
        String[] elementiCorretti = elementi.split("\\|");
        DIMENSIONE = elementiCorretti.length;
        vInteri = new int[DIMENSIONE];
        for(int k = 0; k < DIMENSIONE; k++){
            try{
                vInteri[k] = Integer.parseInt(elementiCorretti[k]);
            } catch (NumberFormatException e){
                throw new NumberFormatException("Elemento non valido: " + elementiCorretti[k]);
            }
        }
    }
    public void add(int elemento) throws ErroreVettorePieno {
        if (nInteri < DIMENSIONE) {
            vInteri[nInteri] = elemento;
            nInteri++;
        } else {
            throw new ErroreVettorePieno();
            //throw new ErroreVettorePieno("hai raggiunto il valore massimo"); scrive tale messaggio
        }
    }

    public int getNumeroMinimo() {
        int min = vInteri[0];
        if (nInteri > 0) {
            for (int k = 1; k < nInteri; k++) {
                if (vInteri[k] < min)
                    min = vInteri[k];
            }
        } else {
            throw new ErroreVettoreVuoto();
        }
        return min;
    }

    public int cercaPosizioneElementoArray(int elemento) throws ErroreElementoInesistente {
        int tro = -1;
        int k = 0;
        while (k < nInteri && tro == -1) {
            if (vInteri[k] == elemento)
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
        for (int k = pos; k < nInteri-1; k++) {
            vInteri[k] = vInteri[k + 1];
        }
        vInteri[nInteri - 1] = 0;
    }

    @Override
    public String toString() {
        String str = "";
        for (int k: vInteri){
            str += k + "|";
        }
        return str;
    }
}

