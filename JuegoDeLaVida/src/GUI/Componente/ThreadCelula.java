package GUI.Componente;

import GUI.Juego;

public class ThreadCelula extends Thread {

      private Celula[][] celulas;
      private int largo;
      private int ancho;

      /**
       * estado == 1 : el juego esta funcionando
       * estado == 0 : el juego esta en pausa o acabado
       */
      private int estado = 0; 

      // la velocidad de ejecucion
      private int velocidad = 500;

      // cuantas veces ejecuta
      private int veces = 0;

      @Override
      public void run() {
            while (true) {
                  
                  if (estado == 1 && (veces == 0 || Juego.ventana.times_game < veces)) {
                        Juego.ventana.registrarNumeroGeneracion();
                        Celula.obtenerSiguienteColor(celulas, largo, ancho);
                        Celula.cambiarColor(celulas);

                        if (Juego.ventana.times_game >= veces && veces != 0) {
                              estado = 0;

                        }

                  }

                  try {
                        Thread.sleep(velocidad);
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
            }
      }

      /**
       * 
       */
      public void pauseGame() {
            estado = 0;
      }

      /**
       * 
       */
      public void continueGame() {
            estado = 1;
      }

      /**
       * 
       * @param speed
       */
      public void setSpeed(int speed) {
            this.velocidad = speed;
      }

      /**
       * 
       * @param times
       */
      public void setTimes(int times) {
            this.veces = times;
      }

      /**
       * 
       * @param c
       */
      public void setCelulas(Celula[][] c) {
            this.celulas = c;
      }

      /**
       * 
       * @param largo
       * @param ancho
       */
      public void setWidthAndHeight(int width, int height) {
            this.largo = width;
            this.ancho = height;
      }
}