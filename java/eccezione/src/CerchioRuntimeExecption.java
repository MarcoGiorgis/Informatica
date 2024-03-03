public class CerchioRuntimeExecption {
    private float raggio;

    public CerchioRuntimeExecption(float raggio) {
        this(); //invoca il costruttore senza paramtetri
        setRaggio(raggio);
    }
    public CerchioRuntimeExecption(){
        raggio = 0;
    }
    public float getRaggio(){
        return raggio;
    }
    public void setRaggio(float raggio) {
        if (raggio >= 0)
            this.raggio = raggio;
        else
            throw new ValoreNonValidoNONcontrollata("Raggio negativo NON CONTROLLATA"); //throw solleva una nuova eccessione
    }
}