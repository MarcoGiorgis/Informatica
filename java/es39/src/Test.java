public class Test {
    public static void main(String[] args) {
        Lavoratore lavoratore = new Lavoratore("a", 2);
        LavoratoreConStraordinarioPagati lavStrPag = new LavoratoreConStraordinarioPagati("b", 3, 15);
        lavoratore.setStipendio(1500);
        lavStrPag.setStipendio(2000);
        lavStrPag.setOreStraordinari(30);
        System.out.println(lavoratore.toString());
        System.out.println(lavStrPag.toString());

        //prova down and up casting
        Lavoratore l1,l2;
        LavoratoreConStraordinarioPagati lv1,lv2,lv3;
        lv1 = new LavoratoreConStraordinarioPagati("D", 3, 100);
        l2 = new Lavoratore("ciao", 4);
        //lv2 = new Lavoratore("Maria", 4); non possibile
        l1 = lv1; //up casting sottointeso sempre possibile l1 = (Lavoratore)lv1;
       //lv2 = (LavoratoreConStraordinarioPagati) l2; non possibile
        lv3 = (LavoratoreConStraordinarioPagati) l1;
        System.out.println(((LavoratoreConStraordinarioPagati)l1).toString());
        Azienda azienda = new Azienda("Marco", "via roma");
        azienda.add(lavoratore);
        //azienda.add(lavStrPag);
        System.out.println(azienda.toString());
    }
}