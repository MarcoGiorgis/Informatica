package serializzazioneCSV;

import originali.Autore;
import originali.Libreria;
import originali.Libro;

import java.io.*;
import java.util.Vector;

public class LibreriaCSV extends Libreria {
    private Vector<Libro> libri;

    public LibreriaCSV() {
        libri = new Vector<Libro>();
    }

    public void addVolume(Libro libro) {
        libri.add(libro);
    }

    //metodi necessari per la deserializzazione
    public Vector<Libro> getLibri() {
        return libri;
    }

    public void setLibri(Vector<Libro> libri) {
        this.libri = libri;
    }

    public float getValore(){
        float tot = 0;
        for(Libro l: libri){
            tot += l.getPrezzo();
        }
        return tot;
    }

    public void salvaSuFile(String nomeFile) throws IOException {
        FileWriter fw = new FileWriter(nomeFile);
        fw.write("CostoPaginaFisso" + "\n");
        fw.write(Libro.getCostoPagina() + "\n");
        fw.write("Titolo" + "," + "Autore" + "," + "NumeroPagine" + "\n");
        for(Libro l: libri) {
            fw.write(l.getTitolo() + "," + l.getAutore() + "," + l.getPrezzo() + "\n");
        }
        fw.close();
    }

    public void caricaDaFile(String nomeFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nomeFile));
        String s = "";
        String[] line = null;
        s = br.readLine();
        s = br.readLine();
        Libro.setCostoPagina(Double.parseDouble(s));
        s = br.readLine();
        s = br.readLine();
        while (s != null) {
            line = s.split(",");
            String titolo = line[0];
            String nomeAutore = line[1];
            String cognomeAutore = line[2];
            int numeroPagine = Integer.parseInt(line[3]);
            Autore autore = new Autore(nomeAutore, cognomeAutore);
            Libro libro = new Libro(titolo, autore, numeroPagine);
            libri.add(libro);
            s = br.readLine();
        }
    }

    @Override
    public String toString() {
        return "Libreria = " + libri ;
    }
}
