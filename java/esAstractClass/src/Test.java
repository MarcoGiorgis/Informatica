public class Test {
    public static void main(String[] args) {
        Animale[] gabbie= new Animale[3];
        gabbie[0] = new Scoiattolo("a");
        gabbie[1] = new Cane("b");
        gabbie[2] = new Leone("c");
        for (int k=0; k< gabbie.length; k++){
            gabbie[k].verso();
            if (gabbie[k] instanceof Cane)
                ((Cane)gabbie[k]).ringhiare(); //downcasting
        }
        Zoo zoo = new Zoo("cuneo", 10);
        zoo.add(gabbie[2]);
        zoo.presentatevi();
    }
}