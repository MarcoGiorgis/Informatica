public class Test {
    public static void main(String[] args) {
        Persona persona = new Persona("Marco", "Giorgis", "GRGMRC06D02D205F");
        Studente studente = new Studente("Marco", "Giorgis", "aaa", "a1","bocconi");
        Docente docente = new Docente("Mario", "Rossi", "inglese", "inglese", 1500);

        System.out.println(persona.toString());
        System.out.println(studente.toString());
        System.out.println(docente.toString());
    }
}