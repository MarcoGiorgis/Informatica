public class Telecomando {
    private boolean acceso = false;
    private int canale;
    private int volume;
    private static int VOLUME_MAX;
    private static int CANALE_MAX;
    private static int DEFUALT_VOLUME = 100;
    private static int DEFAULT_CANALE = 999;
    private boolean mute = true;

    public Telecomando(int volume_max, int canale_max){
        if(volume_max <= 1 || volume_max > DEFUALT_VOLUME)
            VOLUME_MAX = DEFUALT_VOLUME;
        else
            VOLUME_MAX = volume_max;
        if(canale_max <= 1 || canale_max > DEFAULT_CANALE)
            CANALE_MAX = DEFAULT_CANALE;
        else
            CANALE_MAX = volume_max;
    }
    public void setCanale(int canale){
        setOnOff();
        if(canale > CANALE_MAX || canale < 1)
            this.canale = DEFAULT_CANALE;
        else
            this.canale = canale;
    }
    public void setVolume(int volume){
        setMute();
        if(volume > VOLUME_MAX || volume < 1)
            this.volume = DEFUALT_VOLUME;
        else
            this.volume = volume;
    }
    public void setOnOff(){
        acceso = !acceso;
    }
    public void setMute(){
        mute = !mute;
    }
    public void alzaVolume(){
        if(volume < VOLUME_MAX)
            volume = VOLUME_MAX;
        else
            volume ++;
    }
    public void abbassaVolume(){
        if(volume > VOLUME_MAX)
            volume --;
        else
            volume = 0;
    }
    public void alzaCanale(){
        if(canale < CANALE_MAX)
            canale++;
        else
            canale = DEFAULT_CANALE;
    }
    public void abbassaCanale(){
        if(canale > 0)
            canale--;
        else
            canale = 0;
    }
    public int getCanale(){
        return canale;
    }
    public int getVolume(){
        return volume;
    }
    public boolean isAcceso(){
        return acceso;
    }
    public boolean isMute(){
        return mute;
    }
    public String toString(){
        return "Acceso: " + isAcceso() + " Volume: " + getVolume() + " Canale: "
                + getCanale() + " Muto: " + isMute();
    }
}

