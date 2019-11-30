package lab.pkg7_josezuniga_31841432;

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
        Paradas parada = new Paradas();
        double tiempo = 0;
        double dist = 100000000;
        while (continua) {
            if (vive) {
                if (cambio) {
                    for (Estudiante estudiante : bus.getEstudiantes()) {
                        if (dist < estudiante.getParada().getDistancia()) {
                            parada = estudiante.getParada();
                        }
                        tiempo = parada.getDistancia() / bus.getVelocidad();
                    }
                    barrita.setMaximum((int)tiempo);
                }
            }
        }
    }
}
