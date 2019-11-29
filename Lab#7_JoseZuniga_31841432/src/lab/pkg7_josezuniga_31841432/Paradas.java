package lab.pkg7_josezuniga_31841432;

public class Paradas {
    private String nombreP;
    private int distancia;
    private double angulo,  x, y;

    public Paradas() {
    }

    public Paradas(String nombreP, int distancia, double x, double y, double angulo) {
        this.nombreP = nombreP;
        this.distancia = distancia;
        this.x = x;
        this.y = y;
        this.angulo = angulo;
    }
    
    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
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
}
