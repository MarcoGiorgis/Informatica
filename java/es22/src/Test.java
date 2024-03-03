public class Test {
    public static void main(String[] args) {
        Auto auto1 = new Auto("audi", "rosso", 10000);
        Auto auto2 = new Auto("mercedes", "grigio", 20000);
        Concessionaria concessionaria = new Concessionaria("matiauda", 100);
        concessionaria.add(auto1);
        concessionaria.add(auto2);
        System.out.println(concessionaria.toString());
        System.out.println("Valore totale auto: " + concessionaria.getSommaPrezzi());
        concessionaria.getColoriAutoModello("audi");
    }
}