import java.util.Vector;

public class Album{
    private String titolo;
    private Vector <Canzone> vBrani;

    public Album(String titolo, Canzone canzone) {
        this.titolo = titolo;
        vBrani = new Vector<Canzone>();
        add(canzone);
    }
    public void add(Canzone c){
        if(c != null){
            vBrani.add(c);
        }
    }
    public String toString(){
        String str = "";
        for(int k = 0; k < vBrani.size(); k++){
            str += vBrani.get(k).toString() + "\n";
        }
        return str;
    }
}
