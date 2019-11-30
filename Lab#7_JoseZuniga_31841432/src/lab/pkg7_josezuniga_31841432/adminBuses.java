package lab.pkg7_josezuniga_31841432;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class adminBuses {
    
    private ArrayList<Autobus> bus = new ArrayList<>();
    private File archivo = null;
    
    public adminBuses (String path) {
        this.archivo = new File(path);
    }

    public ArrayList<Autobus> getEstu() {
        return bus;
    }

    public void setEstu(ArrayList<Autobus> estu) {
        this.bus = estu;
    }
    
    public Autobus getEstu(int pos) {
        return bus.get(pos);
    }

    public void setEstu(Autobus estu) {
        this.bus.add(estu);
        escribirArchivo();
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    
    public void cargarArchivo() {
        try {            
            bus = new ArrayList();
            Autobus temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Autobus) objeto.readObject()) != null) {
                        System.out.println("hola");
                        bus.add(temp);
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
            for (Autobus t : bus) {
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


