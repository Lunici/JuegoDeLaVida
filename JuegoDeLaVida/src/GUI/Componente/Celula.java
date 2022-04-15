package GUI.Componente;

import java.awt.Color;

import javax.swing.JButton;

public class Celula extends JButton {
      // el siguiente color de la cecula
      public static int[] n_sobrevivir = {2, 3};
      public static int n_renacer = 3;

      // el color de la siguiente ronda
      public Color color_siguiente = Color.black;

      // el numero de vecinos vivos
      private int n_vecino_vivo = 0;

      /**
       * 
       * @param celulas
       * @param largo
       * @param ancho
       */
      public static void obtenerSiguienteColor(Celula[][] celulas, int largo, int ancho) {
            obtenerNumeroVecinosVivos(celulas, largo, ancho);
            for (Celula[] celulas2 : celulas) {
                  for (Celula celula : celulas2) {
                        // si la celula esta viva y no tiene {2, 3} vecinos, muere
                        if (celula.getBackground() == Color.white) {
                              if (!tieneNumero(n_sobrevivir, celula.n_vecino_vivo)) {
                                    celula.color_siguiente = Color.black;
                              }
                              else {
                                    celula.color_siguiente = Color.white;
                              }
                        }
                        // si la celula esta muerta y tiene 3 vecinos, renace
                        else {
                              if (celula.n_vecino_vivo == n_renacer) {
                                    celula.color_siguiente = Color.white;
                              }
                              else {
                                    celula.color_siguiente = Color.black;
                              }
                        }
                        celula.n_vecino_vivo = 0;
                  }
            }
      }

      /**
       * 
       * @param celulas
       * @param largo
       * @param ancho
       */
      private static void obtenerNumeroVecinosVivos(Celula[][] celulas, int largo, int ancho) {
            for (int x = 0; x < largo; x++) {
                  for (int y = 0; y < ancho; y++) {
                        if (celulas[x][y].getBackground() == Color.white) {
                              // en caso de que la celula esta en borde
                              if (x == 0 || y == 0 || x == celulas.length || y == celulas[0].length) {
                                    if (existeLaCelula(largo, ancho, x - 1, y + 1)) {
                                          celulas[x - 1][y + 1].n_vecino_vivo++;
                                    }
                                    if (existeLaCelula(largo, ancho, x, y + 1)) {
                                          celulas[x][y + 1].n_vecino_vivo++;
                                    }
                                    if (existeLaCelula(largo, ancho, x + 1, y + 1)) {
                                          celulas[x + 1][y + 1].n_vecino_vivo++;
                                    }
                                    if (existeLaCelula(largo, ancho, x - 1, y)) {
                                          celulas[x - 1][y].n_vecino_vivo++;
                                    }
                                    if (existeLaCelula(largo, ancho, x + 1, y)) {
                                          celulas[x + 1][y].n_vecino_vivo++;
                                    }
                                    if (existeLaCelula(largo, ancho, x - 1, y - 1)) {
                                          celulas[x - 1][y - 1].n_vecino_vivo++;
                                    }
                                    if (existeLaCelula(largo, ancho, x, y - 1)) {
                                          celulas[x][y - 1].n_vecino_vivo++;
                                    }
                                    if (existeLaCelula(largo, ancho, x + 1, y - 1)) {
                                          celulas[x + 1][y - 1].n_vecino_vivo++;
                                    }
                              }
                              // caso normal
                              else {
                                    celulas[x - 1][y + 1].n_vecino_vivo++;
                                    celulas[x][y + 1].n_vecino_vivo++;
                                    celulas[x + 1][y + 1].n_vecino_vivo++;
                                    celulas[x - 1][y].n_vecino_vivo++;
                                    celulas[x + 1][y].n_vecino_vivo++;
                                    celulas[x - 1][y - 1].n_vecino_vivo++;
                                    celulas[x][y - 1].n_vecino_vivo++;
                                    celulas[x + 1][y - 1].n_vecino_vivo++;
                              }
                        }
                  }
            }
      };

      /**
       * 
       * @param largo
       * @param ancho
       * @param x
       * @param y
       * @return
       */
      private static boolean existeLaCelula(int largo, int ancho, int x, int y) {
            return (x >= 0 && x < largo && y >= 0 && y < ancho) ? true : false;
      }

      /**
       * 
       * @param array
       * @param n
       * @return
       */
      private static boolean tieneNumero(int[] array, int n) {
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
       * 
       * @param celulas
       */
      public static void cambiarColor(Celula[][] celulas) {
            for (Celula[] celulas2 : celulas) {
                  for (Celula celula : celulas2) {
                        celula.setBackground(celula.color_siguiente);
                  }
            }
      }

}
