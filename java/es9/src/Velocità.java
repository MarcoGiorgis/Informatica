public class Velocità {
    private float velKmH;

    public float getKmh(){
        return velKmH;
    }
    public float getVelMs(){
        return (velKmH * 1000);
    }
    public void setVelKmH(float velKmH) {
        this.velKmH = velKmH;
    }
    public void setVelMs(float velKmH){
        getVelMs();
    }
    public Velocità(float velKmH){
        this.velKmH = 10;
    }
    public String toString() {
        return "Velocità km/h: "+ velKmH + "velocità m/s: " + getVelMs();
    }
}
