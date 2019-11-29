package lab.pkg7_josezuniga_31841432;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class administrarParadas  {

    private ArrayList<Paradas> paradas = new ArrayList<>();
    private File archivo = null;
    
    public administrarParadas(String path) {
        this.archivo = new File(path);
    }

    public ArrayList<Paradas> getParadas() {
        return paradas;
    }

    public void setParadas(ArrayList<Paradas> paradas) {
        this.paradas = paradas;
    }
    
    public Paradas getParada(int pos) {
        return paradas.get(pos);
    }

    public void setParada(Paradas parada) {
        this.paradas.add(parada);
        escribirArchivo();
    }
    
    public void cargarArchivo() {
        try {            
            paradas = new ArrayList();
            Paradas temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Paradas) objeto.readObject()) != null) {
                        System.out.println("hola");
                        paradas.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Paradas t : paradas) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
}
