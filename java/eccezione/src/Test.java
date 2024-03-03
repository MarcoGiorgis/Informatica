public class Test {
    public static void main(String[] args) {
        try {
            Cerchio c = new Cerchio(-1);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            cerchioIOexception c1 = new cerchioIOexception(-1);
        } catch (ValoreNonValido e) {
            System.out.println(e.getMessage());
        } finally { //eseguito comunque
            System.out.println("passa di qua");
        }
        try {
            CerchioRuntimeExecption c2 = new CerchioRuntimeExecption(-1);
        } catch (ValoreNonValidoNONcontrollata e){
            System.out.println(e.getMessage());
        }
    }
}
