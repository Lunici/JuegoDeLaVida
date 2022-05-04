package src.Componentes;

import src.*;

/**
 * Esta Clase 
 */

public class ThreadCelula extends Thread {
      private boolean running = false;

      private Celula[][] celulas;
      private int velocidad;
      private int veces_max;

      public void run() {
            while (true) {
                  if (running == true && (veces_max == 0 || Juego.ventana.n_generacion < veces_max)) {
                        Juego.ventana.contarNumeroGeneracion();
                        Celula.obtenerSiguienteColor(celulas);
                        Celula.cambiarColor(celulas);
                  }

                  try {
                        Thread.sleep(velocidad);
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
            }

      }

      public void startGame() {
            running = true;
      }

      public void stopGame() {
            running = false;
      }

      public void configCelulas(Celula[][] celulas) {
            this.celulas = celulas;
      }

      public void configVelocidad(int velocidad) {
            this.velocidad = velocidad;
      }

      public void configNumeroGeneracionMax(int n) {
            this.veces_max = n;
      }
}