public class Figura {
    private String nome;
    private int n_punti;
    private Punto[] vpunti;
    private final int MAX_PUNTI;

    public Figura(String nome, int max_punti) {
        this.nome = nome;
        if (max_punti < 3)
            MAX_PUNTI = 3;
        else
            MAX_PUNTI = max_punti;
        vpunti = new Punto[MAX_PUNTI];
        n_punti = 0;
    }

    public void add(Punto punto) {
        if (punto != null) {
            if (n_punti < MAX_PUNTI) {
                vpunti[n_punti] = punto;
                n_punti++;
            }
        }
    }
    public float calcolaPerimetro() {
        float perimetro = 0;
        if(n_punti == MAX_PUNTI) {
            for (int i = 0; i < n_punti; i++) {
                Punto puntoCorrente = vpunti[i];
                Punto puntoSuccessivo = vpunti[(i + 1) % n_punti];
                perimetro += vpunti[i].getDistanza(puntoCorrente, puntoSuccessivo);
            }
        }
        return perimetro;
    }

    public String toString() {
        String str = "";
        for(int k = 0; k < n_punti; k++){
            str += vpunti[k].toString() + "";
        }
        return "Figura: " + nome + ", Numero di vertici: " + n_punti + ", Cordinare: " + str;
    }
}

