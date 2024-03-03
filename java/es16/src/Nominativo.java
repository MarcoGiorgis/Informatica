public class Nominativo {
    private String nome;
    private String cognome;
    private int giorno;
    private int mese;
    private int anno;
    private char sesso;
    private static int GIORNIMAX = 31;
    private static int MESEMAX = 12;
    private static int ANNOMAX = 2023;

    public Nominativo(String nome, String cognome, int giorno, int mese, int anno, char sesso){
        setNome(nome);
        setCognome(cognome);
        setGiorno(giorno);
        setMese(mese);
        setAnno(anno);
        setSesso(sesso);
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    public void setGiorno(int giorno){
        if(giorno <= GIORNIMAX)
            this.giorno = giorno;
        else
            this.giorno = 0;
    }
    public void setMese(int mese){
        if(mese <= MESEMAX)
            this.mese = mese;
        else
            this.mese = 0;
    }
    public void setAnno(int anno){
        if(anno <= ANNOMAX)
            this.anno = anno;
        else
            this.anno = 0;
    }
    public void setSesso(char sesso){
        if(sesso == 'm' || sesso == 'f' || sesso == 'M' || sesso == 'F')
            this.sesso = sesso;
        else
            this.sesso = 'n';
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public int getGiorno() {
        return giorno;
    }
    public int getMese() {
        return mese;
    }
    public int getAnno() {
        return anno;
    }
    public char getSesso(){
        return sesso;
    }
    public String iniziali(){
        String nomeIniziali;
        String cognomeIniziali;
        //int cont;
        if(nome.length() >= 3)
            nomeIniziali = nome.substring(0, 3);
        else
            nomeIniziali = nome + "xxx"; //cont = nome.length();
        if(cognome.length() >= 3)
            cognomeIniziali = cognome.substring(0, 3);
        else
            cognomeIniziali = cognome.substring(0, 3);
        return nomeIniziali + cognomeIniziali;
    }
    public String inizialiCF(){
        String CF = "";
        char car;
        int j = 0;
        int k = 0;
        String temp = "";

        while (k < cognome.length() && j < 3){
            car = cognome.charAt(k);
            if(isConsonante(car)){
                temp += car;
                j++;
            }

            k++;
        }
        k = 0;
        while (k < cognome.length() && j < 3){
            car = cognome.charAt(k);
            if(isVocale(car)){
                temp += car;
                j++;
            }
            k++;
        }

        CF = (temp + "xxx").substring(0,3);

        k = 0;
        j = 0;
        temp = "";
        while (k < nome.length() && j < 3){
            car = nome.charAt(k);
            if(isConsonante(car)){
                temp += car;
                j++;
            }
            k++;
        }

        while (k < nome.length() && j < 3){
            car = nome.charAt(k);
            if(isVocale(car)){
                temp += car;
                j++;
            }
            k++;
        }

        CF = CF + (temp + "xxx").substring(0,3);

        int cifreAnno = (anno % 100);

        if(cifreAnno < 10){
            CF = CF + 0 + cifreAnno;
        }else {
            CF = CF + cifreAnno;
        }

        String carattereMese = "ABCDEHLMPRST";

        CF = CF + carattereMese.charAt(mese - 1);

        if(sesso == 'M'){
            if(giorno < 10){
                CF = CF + 0 + giorno;
            }else {
                CF += giorno;
            }
        }else{
            CF = CF + (giorno + 40);
        }

        return CF.toUpperCase();
    }
    private boolean isVocale(char car){
        return (car == 'a' || car == 'e' || car == 'i' || car == 'o' || car == 'u' ||
                car == 'A' || car == 'E' || car == 'I' || car == 'O' || car == 'U');
    }
    private boolean isConsonante(char car){
        return isVocale(car) && ((car > 'a' && car <= 'z') || (car > 'A' && car <= 'Z'));
    }
    public boolean eOmocodice(Nominativo altroNom){
        return this.inizialiCF().equals(altroNom.inizialiCF());
    }
    public String toString(){
        return "Nominativo [" + "cognome: " + getCognome() +
                " nome: " + getNome() + " giorno: " + getGiorno() + "mese: " + getMese() +
                " anno: " + getAnno() + " sesso: " + getSesso()+"]";
    }
}
