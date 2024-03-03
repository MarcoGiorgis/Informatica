public class Test { //static = può essere invocato senza avere istanze a cui appartiene
    public static void main(String[] args) { //public visibile da tutti void = non restituisce nulla
        Mostro mio; //occupa lo spazio di un puntatore
        mio = new Mostro("bramardi", -10, 100, 6); //istruzione per convocare l'istruttore
        System.out.println("il mio mostro ora è " + mio.toString()); //sout (comando per l'output) mettere ln = \n
        //to string converte il mostro a una stringa
        //sempre nome dell'oggetto + metodo
        //System.out.print("ciao");

        Mostro tuo = new Mostro("roberto", 6);//new = malloc alloca lo spazio in memoria
        mio.setVita(mio.getVita() + 1); //incrementa la vita di uno

        System.out.println("il mio mostro ora è " + mio.toString());
        System.out.println("il tuo mostro ora è " + tuo.toString());
        mio.gioca(tuo);
    }
}
