package src.Ventana;

/**
 * Esta CLASE es para comprobar si las configuraciones (settings) son válidos
 * Incluido "largo", "ancho", "velocidad", "veces" y "AA/B"
 */

public class Settings {
      /**
       * Es una funcion pública para comprobar si las configuraciones (settings) son válidos
       */
      public static boolean esValido(String largo, String ancho, String velocidad, String veces, String aab) {
            boolean valido = false;
            if (esInt(largo) && esInt(ancho) && esInt(velocidad) && esInt(veces) && esAABValido(aab)) {
                  // Comprobación de mínimos y máximos
                  if (Integer.parseInt(ancho) >= 15 && Integer.parseInt(largo) >= 15 && Integer.parseInt(velocidad) >= 100) {
                        if (Integer.parseInt(veces) >= 0) {
                              valido = true;
                        }
                  }
            }
            return valido;
      }

      /**
       * Comprobamos si todos los caracteres son numerales
       * @param n el numero que quiere comprobar
       */
      private static boolean esInt(String n) {
            boolean resultado = true;
            for (int i = 0; i < n.length(); i++) {
                  if (!Character.isDigit(n.charAt(i))) {
                       resultado = false;
                       break; 
                  }
            }
            return resultado;
      }

      /**
       * Comprobar el aab si un AA/B válido
       * @param aab el String que quiere comprobar
       */
      private static boolean esAABValido(String aab) {
            boolean resultado = false;
            if (aab.length() == 4) {
                  if (aab.charAt(2) == '/' && Character.isDigit(aab.charAt(0)) && Character.isDigit(aab.charAt(1)) && Character.isDigit(aab.charAt(3))) {
                        int n1 = (int)aab.charAt(0) - 48;
                        int n2 = (int)aab.charAt(1) - 48;
                        int n3 = (int)aab.charAt(3) - 48;
                        if (entreUnoOcho(n1) && entreUnoOcho(n2) && entreUnoOcho(n3)) {
                              resultado = true;
                        }
                  }
            }
            return resultado;
      }

      /* Comprobar si el numero esta entre 1 y 8 */
      private static boolean entreUnoOcho(int n) {
            return (n >= 1 && n <= 8) ? true : false;
      }
}