package lab.pkg7_josezuniga_31841432;

import java.io.Serializable;

public class Paradas implements Serializable{
    private String nombreP;
    private double distancia;
    private double angulo,  x, y;

    public Paradas() {
    }

    public Paradas(String nombreP, double distancia, double angulo) {
        this.nombreP = nombreP;
        this.distancia = distancia;
        this.angulo = angulo;
        setX();
        setY();
    }
    
    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
        setX();
        setY();
    }

    public double getX() {
        return x;
    }

    public void setX() {
        this.x = distancia * Math.cos(angulo);
    }

    public double getY() {
        return y;
    }

    public void setY() {
        this.y = distancia * Math.sin(angulo);
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
        setX();
        setY();
    }

    @Override
    public String toString() {
        return nombreP;
    }
}
