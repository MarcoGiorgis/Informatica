import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        Vector <Solido> solidi = new Vector<>();

        solidi.add(new Cubo(2.0, 4.0));
        solidi.add(new Sfera(2.0, 4.0));

        for(int k = 0; k < solidi.size(); k++){
            System.out.println("Peso: " + solidi.get(k).getPeso());
            System.out.println("Superficie: " + solidi.get(k).getSuperficie());
            System.out.println("Volume: " + solidi.get(k).getVolume());
        }
    }
}