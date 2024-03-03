public class Test {
    public static void main(String[] args) {
        Solido[] solidi = new Solido[2];
        Sfera s1 = new Sfera(10, 10);
        Cubo c1 = new Cubo(15,15);
        solidi[0] = s1;
        solidi[1] = c1;
        for(int k = 0; k < solidi.length; k++){
            System.out.println(solidi[k].toString());
        }
        System.out.println(s1.toString());
        System.out.println(c1.toString());
    }
}