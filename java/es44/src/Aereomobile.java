public abstract class Aereomobile {
    private String sigla;

    public Aereomobile(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

    public boolean eLoStesso(Aereomobile a){
        if(this.sigla.equals(a.getSigla()))
            return true;
        else
            return false;
    }

    public String toString(){
        return "Sigla: " + sigla;
    }
}
