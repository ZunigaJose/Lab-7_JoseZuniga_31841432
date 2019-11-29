package lab.pkg7_josezuniga_31841432;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class adminEstudiante {
    private ArrayList<Estudiante> estu = new ArrayList<>();
    private File archivo = null;
    
    public adminEstudiante(String path) {
        this.archivo = new File(path);
    }

    public ArrayList<Estudiante> getEstu() {
        return estu;
    }

    public void setEstu(ArrayList<Estudiante> estu) {
        this.estu = estu;
    }
    
    public Estudiante getEstu(int pos) {
        return estu.get(pos);
    }

    public void setEstu(Estudiante estu) {
        this.estu.add(estu);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    
    public void cargarArchivo() {
        try {            
            estu = new ArrayList();
            Estudiante temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Estudiante) objeto.readObject()) != null) {
                        System.out.println("hola");
                        estu.add(temp);
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
            for (Estudiante t : estu) {
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


