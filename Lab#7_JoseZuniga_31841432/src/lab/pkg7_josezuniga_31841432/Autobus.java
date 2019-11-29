package lab.pkg7_josezuniga_31841432;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class Autobus implements Serializable {
    private int id;
    private String placa;
    private double velocidad;
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private Color color;

    public Autobus() {
    }

    public Autobus(int id, String placa, double velocidad, Color color) {
        this.id = id;
        this.placa = placa;
        this.velocidad = velocidad;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
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
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
