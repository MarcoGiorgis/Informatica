public class cerchioIOexception {
    private float raggio;

    public cerchioIOexception(float raggio) throws ValoreNonValido {
        this(); //invoca il costruttore senza paramtetri
        setRaggio(raggio);
    }
    public cerchioIOexception(){
        raggio = 0;
    }
    public float getRaggio(){
        return raggio;
    }
    public void setRaggio(float raggio) throws ValoreNonValido { //questo metodo solleva un eccezione di valore non valido
        if (raggio >= 0)
            this.raggio = raggio;
        else
            throw new ValoreNonValido(); //throw solleva una nuova eccessione
    }
}