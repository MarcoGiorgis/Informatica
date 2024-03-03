public class Test {
    public static void main(String[] args) {
        Nominativo persona = new Nominativo("Marco", "Giorgis",2, 4,2006, 'm');
        Nominativo persona1 = new Nominativo("Ale", "Prandi", 15, 5, 2006, 'm');
        System.out.println(persona.toString());
        System.out.println(persona.iniziali());
        System.out.println(persona.inizialiCF());
        boolean stessoOmocodice = persona.eOmocodice(persona1);
        System.out.println("I nominativi generano lo stesso Omocodice: " + stessoOmocodice);
    }
}