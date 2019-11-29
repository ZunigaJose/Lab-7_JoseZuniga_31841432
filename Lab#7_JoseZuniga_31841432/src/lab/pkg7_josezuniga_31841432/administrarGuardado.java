package lab.pkg7_josezuniga_31841432;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class administrarGuardado {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Autobus> buses = new ArrayList<>();
    private ArrayList<Paradas> paradas = new ArrayList<>();
    private File fileBus = new File("./Buses.btu");
    private File fileEstudiantes = new File("./Estudiantes.btu");
    private File fileParada = new File("./Parada.btu");

    public administrarGuardado() {
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    public Estudiante getEstudiante(int pos) {
        return estudiantes.get(pos);
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
        guardarEstudiantes();
    }

    public ArrayList<Autobus> getBuses() {
        return buses;
    }

    public void setBuses(ArrayList<Autobus> buses) {
        this.buses = buses;
    }
    
    public Autobus getBus(int pos) {
        return buses.get(pos);
    }

    public void setBus(Autobus bus) {
        this.buses.add(bus);
        guardarBus();
    }

    public Paradas getParada(int pos) {
        return paradas.get(pos);
    }

    public void setParada(Paradas parada) {
        this.paradas.add(parada);
        guardarParadas();
    }
    
    public void guardarBus() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(fileBus);
            bw = new ObjectOutputStream(fw);
            for (Autobus bus : buses) {
                bw.writeObject(bus);
            }
            bw.flush();
        } catch (Exception e) {
            
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
                
            }
        }
    }
    
    public void guardarEstudiantes(){
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(fileEstudiantes);
            bw = new ObjectOutputStream(fw);
            for (Estudiante estudiante : estudiantes) {
                bw.writeObject(estudiante);
            }
            bw.flush();
        } catch (Exception e) {
            
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
                
            }
        }
    }
    
    public void guardarParadas() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(fileParada);
            bw = new ObjectOutputStream(fw);
            for (Paradas parada : paradas) {
                bw.writeObject(parada);
            }
            bw.flush();
        } catch (Exception e) {
            
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
                
            }
        }
    }
    
    public void leerParada(){
        paradas = new ArrayList<>();
        Paradas temp;
        try {
            FileInputStream entrada = new FileInputStream(fileParada);
            ObjectInputStream objeto = new ObjectInputStream(entrada);
            try {
                while ((temp = (Paradas)objeto.readObject()) != null) {
                    paradas.add(temp);
                }
            } catch (Exception e) {
            }
            objeto.close();
            entrada.close();
        } catch (Exception e) {
        }
    }
    
    public void leerBus(){
        buses = new ArrayList<>();
        Autobus temp;
        try {
            FileInputStream entrada = new FileInputStream(fileBus);
            ObjectInputStream objeto = new ObjectInputStream(entrada);
            try {
                while ((temp = (Autobus)objeto.readObject()) != null) {
                    buses.add(temp);
                }
            } catch (Exception e) {
            }
            objeto.close();
            entrada.close();
        } catch (Exception e) {
        }
    }
    
    public void leerEstudiante (){
        estudiantes = new ArrayList<>();
        Estudiante temp;
        try {
            FileInputStream entrada = new FileInputStream(fileEstudiantes);
            ObjectInputStream objeto = new ObjectInputStream(entrada);
            try {
                while ((temp = (Estudiante)objeto.readObject()) != null) {
                    estudiantes.add(temp);
                }
            } catch (Exception e) {
            }
            objeto.close();
            entrada.close();
        } catch (Exception e) {
        }
    }
    
    
}
