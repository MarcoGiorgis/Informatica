import java.util.Vector;

public class Piano {
    private char lettera;
    private double maxAlt;
    private int progPosto;
    private Vector<PostoAuto> vPosti;

    public Piano(double maxAlt) {
        this.maxAlt = maxAlt;
    }

    public void addPostoAuto(PostoAuto p){
        if(p != null){
            vPosti.add(p);
        }
    }

    public char getLettera() {
        return lettera;
    }

    public double getMaxAlt() {
        return maxAlt;
    }

    public int getProgPosto() {
        return progPosto;
    }

    public Vector<PostoAuto> getvPosti() {
        return vPosti;
    }

    public String getPostiLiberi(){
        String str = "";
        for(PostoAuto p: vPosti){
            if(!p.isOccupato()){
                str += "Posto auto: " + p.getIndice();
            }
        }
        return str;
    }



    @Override
    public String toString() {
        String str = "";
        for(PostoAuto p: vPosti){
            str += vPosti.toString();
        }
        return "Piano: " + " lettera: " + lettera + " max altezza: " + maxAlt + str;
    }
}
