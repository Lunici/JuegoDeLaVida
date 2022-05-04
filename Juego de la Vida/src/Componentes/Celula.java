package src.Componentes;

import java.awt.Color;
import javax.swing.JButton;

public class Celula extends JButton {
      public Color color_siguiente;

      private int n_vecinos_vivos = 0;

      private static int[] n_sobrevivir = {2, 3};
      private static int n_renacer = 3;

      /**
       * Esta funcion es para saber que color será el "siguiente_color" de cada Celula
       * Primero ejecuta la funcion obtenerNumeroVecinosVivos() para saber cuantos vecinos vivos tienen cada Celula
       * Despúes pasamos las celulas uno por uno, determinar el "siguiente_color" por el número de vecinos vivos que tienen
       * @param celulas el array de celulas que quiere operar
       */
      public static void obtenerSiguienteColor(Celula[][] celulas) {
            // Determinar cuantas vecinos vivos tienen
            obtenerNumeroVecinosVivos(celulas);

            // Determine el siguiente color por el número de sus vecinos vivos.
            for (Celula[] celulas2 : celulas) {
                  for (Celula celula : celulas2) {
                        // si la celula es blanca...
                        if (celula.getBackground() == Color.WHITE) {
                              // si tiene {2, 3} vecinos vivos...
                              if (existeEnArray(n_sobrevivir, celula.n_vecinos_vivos)) {
                                    celula.color_siguiente = Color.WHITE;
                              }
                              // si no tiene...
                              else {
                                    celula.color_siguiente = Color.BLACK;
                              }
                        }
                        // si la celula es negra...
                        else {
                              // si tiene 3 vecinos vivos...
                              if (n_renacer == celula.n_vecinos_vivos) {
                                    celula.color_siguiente = Color.WHITE;
                              }
                              // si no tiene 3 vecinos vivos...
                              else {
                                    celula.color_siguiente = Color.BLACK;
                              }
                        }

                        //
                        celula.n_vecinos_vivos = 0;
                  }
            }
      }

      /**
       * Esta función es para calcular cuantos vecinos vivos tiene cada celula
       * LÓGICA: Pasar por todas las células, si está VIVA, el n_vecinos_vivos de sus vecinos suma UNO
       * PRECAUCIÓN!: Cuando la célula esta en bordes, no tendrá 8 vecinos
       * @param celulas el array de Celula que quiere operar
       */
      private static void obtenerNumeroVecinosVivos(Celula[][] celulas) {
            for (int x = 0; x < celulas.length; x++) {
                  for (int y = 0; y < celulas[0].length; y++) {
                        // si esta vivo (blanco)
                        if (celulas[x][y].getBackground() == Color.WHITE) {
                              // si la célula esta en bordes
                              if (x == 0 || y == 0 || x == celulas.length - 1 || y == celulas[0].length - 1) {
                                    if (existeLaCelula(celulas, x - 1, y + 1)) {
                                          celulas[x - 1][y + 1].n_vecinos_vivos++;
                                    }
                                    if (existeLaCelula(celulas, x, y + 1)) {
                                          celulas[x][y + 1].n_vecinos_vivos++;
                                    }
                                    if (existeLaCelula(celulas, x + 1, y + 1)) {
                                          celulas[x + 1][y + 1].n_vecinos_vivos++;
                                    }
                                    if (existeLaCelula(celulas, x - 1, y)) {
                                          celulas[x - 1][y].n_vecinos_vivos++;
                                    }
                                    if (existeLaCelula(celulas, x + 1, y)) {
                                          celulas[x + 1][y].n_vecinos_vivos++;
                                    }
                                    if (existeLaCelula(celulas, x - 1, y - 1)) {
                                          celulas[x - 1][y - 1].n_vecinos_vivos++;
                                    }
                                    if (existeLaCelula(celulas, x, y - 1)) {
                                          celulas[x][y - 1].n_vecinos_vivos++;
                                    }
                                    if (existeLaCelula(celulas, x + 1, y - 1)) {
                                          celulas[x + 1][y - 1].n_vecinos_vivos++;
                                    }
                              }
                              // caso general
                              else {
                                    celulas[x - 1][y + 1].n_vecinos_vivos++;
                                    celulas[x][y + 1].n_vecinos_vivos++;
                                    celulas[x + 1][y + 1].n_vecinos_vivos++;
                                    celulas[x - 1][y].n_vecinos_vivos++;
                                    celulas[x + 1][y].n_vecinos_vivos++;
                                    celulas[x - 1][y - 1].n_vecinos_vivos++;
                                    celulas[x][y - 1].n_vecinos_vivos++;
                                    celulas[x + 1][y - 1].n_vecinos_vivos++;
                              }

                        }
                  }
            }
      }

      /**
       * Esta función te dice si el número "n" existe en el "array"
       * @param array el array de int
       * @param n el número
       */
      private static boolean existeEnArray(int[] array, int n) {
            boolean resultado = false;
            for (int i : array) {
                  if (i == n) {
                        resultado = true;
                        break;
                  }
            }
            return resultado;
      }

      /**
       * Esta función te dice si la "célula[x][y]" existe en "celulas"
       * @param celulas el array de células
       * @param x el x de la célula
       * @param y el y de la célula
       */
      private static boolean existeLaCelula(Celula[][] celulas, int x, int y) {
            return (x >= 0 && x < celulas.length && y >= 0 && y < celulas[0].length) ? true : false;
      }


      /**
       * Esta función cambia el color de cada célula 
       * @param celulas el array de celulas que cambia el color
       */
      public static void cambiarColor(Celula[][] celulas) {
            for (Celula[] celulas2 : celulas) {
                  for (Celula celula : celulas2) {
                        celula.setBackground(celula.color_siguiente);
                  }
            }
      }

      public static void configAAB(String aab) {
            n_sobrevivir[0] = (int)aab.charAt(0) - 48;
            n_sobrevivir[1] = (int)aab.charAt(1) - 48;
            n_renacer = (int)aab.charAt(3) - 48;
      }
}