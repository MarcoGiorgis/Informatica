public class LavoratoreConStraordinarioPagati extends Lavoratore{
    private int oreStraordinari;
    private static double RETRIBUZIONE_ORARIA = 10.0;
    private final static int DEF_ORE_STR = 10;

    public LavoratoreConStraordinarioPagati(String nome, int livello, int oreStraordinari) {
        super(nome, livello);
        if(oreStraordinari > 0)
            this.oreStraordinari = oreStraordinari;
        else
            this.oreStraordinari = DEF_ORE_STR;
    }

    public int getOreStraordinari() {
        return oreStraordinari;
    }

    public void setOreStraordinari(int oreStraordinari) {
        if(oreStraordinari > 0)
            this.oreStraordinari = oreStraordinari;
        else
            this.oreStraordinari = DEF_ORE_STR;
    }
    public static void setRetribuzioneOraria(double retribuzioneOraria){
        if(retribuzioneOraria > 0)
            RETRIBUZIONE_ORARIA = retribuzioneOraria;
    }
    public double getStipendio(){
        return super.getStipendio() + (oreStraordinari * RETRIBUZIONE_ORARIA);
    }

    public String toString() {
        return super.toString() + " Ore straordinario: " + oreStraordinari + " Stipendio Finale: "
                + getStipendio();
    }
}
