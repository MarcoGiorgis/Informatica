import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int max = 100;
        int min = 10;
        int vett[] = new int[20];
        Random random = new Random();
        for(int k = 0; k < vett.length; k++) {
            vett[k] = (int) (Math.random() * (max - min + 1) + min);
            for(int j = k; j > 0; j--){
                if(vett[k] == vett[j])
                    vett[k] = random.nextInt(91) + 10;
            }
        }
        for(int el: vett){
            System.out.println(el);
        }
    }
}
