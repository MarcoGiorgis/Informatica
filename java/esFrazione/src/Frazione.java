import javax.print.DocFlavor;

public class Frazione {
    private char segno;
    private int denominatore;
    private int numeratore;
    private final static char DEF_SEGNO = '+';
    private final static int DEF_DENOMINATORE = 10;
    private final static int DEF_NUMERATORE = 0;
    //private final static String[] POS_SEGNI = {"+", "-", "*", "/"};

    public Frazione(){
        /*
        this.segno = DEF_SEGNO;
        this.numeratore = DEF_NUMERATORE;
        this.denominatore = DEF_DENOMINATORE;
         */
        this(DEF_SEGNO, DEF_NUMERATORE, DEF_DENOMINATORE);
    }
    public Frazione(char segno, int numeratore){
        /*
        this.segno = segno;
        if(numeratore >= 0)
            this.numeratore = numeratore;
        else
            this.numeratore = DEF_NUMERATORE;
        this.denominatore = DEF_DENOMINATORE;
         */
        this(segno, numeratore, DEF_DENOMINATORE); //invoca il prorpio costruttore
    }
    public Frazione(char segno, int numeratore, int denominatore){
        this.segno = segno;
        if(numeratore >= 0)
            this.numeratore = numeratore;
        else
            this.numeratore = DEF_NUMERATORE;
        if(denominatore > 0)
            this.denominatore = denominatore;
        else
            this.denominatore = DEF_DENOMINATORE;
    }

    public void setSegno(char segno) {
        if(segno == '+' || segno == '-') {
            this.segno = segno;
        }
    }

    public void setNumeratore(int numeratore) {
        if(numeratore > 0) {
            this.numeratore = numeratore;
        }
    }

    public void setDenominatore(int denominatore) {
        if(denominatore > 0) {
            this.denominatore = denominatore;
        }
    }

    public char getSegno(){
        return segno;
    }

    public int getNumeratore() {
        return numeratore;
    }

    public int getDenominatore() {
        return denominatore;
    }
    public float getValore(){
        float valore;
        valore = (float) numeratore/denominatore;
        if(segno == '-'){
            valore *= -1;
        }
        return valore;
    }
    public boolean equals(Frazione f) {
        boolean stessoValore = false;
        if(getValore() == f.getValore()){
            stessoValore = true;
        }
        return stessoValore;
        //return (getValore() == f.getValore())
    }
    public String toString(){
        return segno + numeratore + "/" + denominatore;
    }
}
