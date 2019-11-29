package lab.pkg7_josezuniga_31841432;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private String nombre, cuenta;
    private Paradas parada;
    private int edad;

    public Estudiante() {
    }

    public Estudiante(String nombre, String cuenta, Paradas parada, int edad) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.parada = parada;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Paradas getParada() {
        return parada;
    }

    public void setParada(Paradas parada) {
        this.parada = parada;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + ", Parada: " + parada;
    }
}
