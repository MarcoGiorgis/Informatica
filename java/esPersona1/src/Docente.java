public class Docente extends Persona{

    private String materia;
    private float salario;

    public Docente(String nome, String cognome, String codiceFiscale, String materia, float salario){
        super(nome, cognome, codiceFiscale);
        this.materia = materia;
        this.salario = salario;
    }
    public String getMateria(){
        return materia;
    }
    public float getSalario(){
        return salario;
    }
    public void setMateria(String materia){
        this.materia = materia;
    }
    public void setSalario(float salario){
        this.salario = salario;
    }
    public String toString(){
        return super.toString() + " Materia: " + materia + " Salario: " + salario;
    }
}
