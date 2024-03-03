public class Test {
    public static void main(String[] args) {
        Videoteca v1 = new Videoteca("a", "Via giacomo", 10);
        CD c1 = new CD("ciao", 120, 10);
        CD.setPrezzo(10);
        System.out.println(c1);
        DVD d1 = new DVD("tarzan", 7200);
        d1.add(TipoLingua.ITA);
        d1.add(TipoLingua.ITA);
        System.out.println(d1);
        v1.Add(c1);
        v1.Add(d1);
        v1.Vendo(3);
        v1.Vendo(2);
        v1.Compro(4);
        c1.setnCopie(5);
        System.out.println(v1.toString());
        VideotecaVector videotecaVector = new VideotecaVector("Giorgis", "via roma");
        videotecaVector.add(c1);
        videotecaVector.add(d1);
        System.out.println(videotecaVector.getValoreNegozio());
        videotecaVector.compro(1);
        videotecaVector.vendo(0);
        System.out.println(c1);
        System.out.println(d1);
        System.out.println(videotecaVector.toString());
    }
}