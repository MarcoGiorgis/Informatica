 public class Temperatura {
    private float tempC;

    public float getTempC(){
        return tempC;
    }
    public float getTempF(){return  (tempC * 9 / 5) + 32;
    }
    public void setTempC(float tempC){
        this.tempC = tempC;
    }
    public void setTempF(float tempC){
        getTempF();
    }
    public Temperatura(float tempC){
        this.tempC = 10;
    }
    public String toString() {
        return "la temperatura in centigradi è "+ tempC + " mentre in faranyte è "+ getTempF();
    }
}
