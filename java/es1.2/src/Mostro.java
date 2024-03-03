import java.lang.reflect.MalformedParameterizedTypeException;

public class Mostro { //ctrl + alt + l per formattare
    private String nome;
    private int vita; //private = visibile solo a te
    private int forza;
    private int lancio;

    private static final int MIN_VITA = 0; //final = costante, static = uguale per tutte le classi
    private static final int MAX_VITA = 100;
    private static final int MIN_FORZA = 5;
    private static final int MAX_FORZA = 10;

    private final int FACCE;
    private final static int DEFAULT_FACCE = 6;

    public Mostro (String nome, int forza, int vita, int facce){
        this.nome = nome; //this rappresenta l'oggetto su cui stiamo operando
        FACCE = (facce >= DEFAULT_FACCE)? facce:DEFAULT_FACCE; //sinonimo di
        /*
        if(facce >= DEFAULT_FACCE)
            FACCE = facce;
        else
            FACCE = DEFAULT_FACCE;
         */
        if(forza >= MIN_FORZA && forza <= MAX_FORZA)
            this.forza = forza;
        else
            this.forza = MIN_FORZA;
        if(vita >= MIN_VITA && vita <= MAX_VITA)
            this.vita = vita;
        else
            this.vita = MAX_VITA / 2;
    }
    public Mostro(String nome, int facce){
        this.nome = nome;
        FACCE = (facce >= DEFAULT_FACCE)? facce:DEFAULT_FACCE;
        this.vita = (int)(Math.random()*(MAX_VITA-MIN_VITA+1))+MIN_VITA;
        this.forza = (int)(Math.random()*(MAX_FORZA -MIN_FORZA+1))+MIN_FORZA;
    }
    public String toString() {
        return nome + ": forza = " + forza + ", vita = " + vita; //operatore + in grado di operare su variabili di tipo diverso
    }
    public int getVita(){
        return vita;
    }
    public int getForza(){
        return forza;
    }
    public String getNome(){
        return nome;
    }
    public void setVita(int vita) {
        if (vita >= MIN_VITA && vita <= MAX_VITA)
            this.vita = vita;
        else if (vita < MIN_VITA)
            this.vita = MIN_VITA;
        else if (vita > MAX_VITA)
            this.vita = MAX_VITA;
    }
    public void setForza(int forza){
        if(forza >= MIN_FORZA && forza <= MAX_FORZA)
            this.forza = forza;
        else
            this.forza = MIN_FORZA;
    }
    private int getLancio(){
        return ((int)(Math.random()*FACCE)+1);
    }
    public void attaccatoDa(Mostro m){
        int dado = getLancio();
        System.out.println(dado);
        setVita(vita - dado * m.getForza()); //rimane a zero
    }
    public void gioca(Mostro m){
        while (vita > 0 && m.getVita() > 0) {
            attaccatoDa(m);
            System.out.println(this);
            if (this.vita > 0) {
                m.attaccatoDa(this);
                System.out.println(m);
            }
        }
        System.out.println("Ha vinto:");
        if(vita == 0)
            System.out.println(m.getNome());
        else
            System.out.println(nome);
    }
}
