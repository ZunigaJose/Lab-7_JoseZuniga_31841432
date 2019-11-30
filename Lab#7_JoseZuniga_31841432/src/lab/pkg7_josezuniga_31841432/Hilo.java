package lab.pkg7_josezuniga_31841432;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class Hilo implements Runnable {
    private JProgressBar barrita;
    private boolean vive = true;
    private boolean continua = true;
    private Autobus bus;

    public Hilo(JProgressBar barrita, Autobus bus) {
        this.barrita = barrita;
        this.bus = bus;
    }

    @Override
    public void run() {
        boolean cambio = true;
        Paradas parada = new Paradas("Unitec", 0, 0);
        Paradas p2 = new Paradas();
        double tiempo = 0;
        double dist = 100000000;
        while (continua) {
            if (vive) {
                if (cambio) {
                    for (Estudiante estudiante : bus.getEstudiantes()) {
                        System.out.println("hola");
                        double distanciaEntre = Math.sqrt((Math.pow(estudiante.getParada().getX() - parada.getX(), 2)) + 
                                Math.pow(estudiante.getParada().getY() - parada.getY(), 2));
                        if (dist < distanciaEntre) {
                            p2 = estudiante.getParada();
                            dist = distanciaEntre;
                        }
                        tiempo = ((Double)distanciaEntre / (Double)bus.getVelocidad()) * 60;
                    }
                    barrita.setMaximum((int)tiempo);
                    
                }
                barrita.setValue(barrita.getValue() + 1);
                if (barrita.getValue() == barrita.getMaximum()) {
                    cambio = true;
                    parada = p2;
                    dist = 10000000;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
    }
}
