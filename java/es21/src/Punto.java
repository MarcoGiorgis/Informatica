public class Punto {
    private float coordx;
    private float coordy;

    public Punto() {
        coordx = 0;
        coordy = 0;
    }

    public Punto(float coordx, float coordy) {
        setX(coordx);
        setY(coordy);
    }

    public void setX(float x) {
        this.coordx = x;
    }

    public void setY(float y) {
        if (y >= 0)
            this.coordy = y;
    }

    public float getX() {
        return coordx;
    }
    public float getY() {
        return coordy;
    }
    public float getDistanza(Punto puntoCorrente, Punto puntoSuccessivo){
        float distanza;
        return distanza = (float) Math.sqrt(Math.pow(puntoSuccessivo.getX() - puntoCorrente.getX(), 2)
                + Math.pow(puntoSuccessivo.getY() - puntoCorrente.getY(), 2));
    }
    public String toString() {
        return "(" + coordx + ", " + coordy + ")";
    }
}
