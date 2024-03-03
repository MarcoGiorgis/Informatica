public class Test2 {
    //eccezzione non controllata
    public static void main(String[] args) throws ErroreVettorePieno{
        VettoreInteri v = new VettoreInteri(1);
        v.add(6);
        v.add(8);
    }
}