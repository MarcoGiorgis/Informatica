public class Cerchio {

    //le eccezzioni fanno parte assieme agli errori della classe Throwable
    //gli errori non sono controllabili mentre le eccessioni si
    private float raggio;

    public Cerchio(float raggio) {
        this(); //invoca il costruttore senza paramtetri
        setRaggio(raggio);
    }
    public Cerchio(){
        raggio = 0;
    }
    public float getRaggio(){
        return raggio;
    }
    public void setRaggio(float raggio) {
        if (raggio >= 0)
            this.raggio = raggio;
        else
            throw new IllegalArgumentException("Raggio negativo"); //throw solleva una nuova eccessione
    }
}