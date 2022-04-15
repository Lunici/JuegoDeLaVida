package GUI.Comprobacion;

public class Comprobacion {
      public static boolean EsSettingValido(String width, String height, String speed, String times) {
            boolean resultado = false;
            if (esInt(width) && esInt(height) && esInt(speed) && esInt(times)) {
                  int w = Integer.parseInt(width);
                  int h = Integer.parseInt(height);
                  int s = Integer.parseInt(speed);
                  int t = Integer.parseInt(times);
                  if (w >= 30 && h >= 20 && s >= 100 && t >= 0) {
                        resultado = true;
                  }
            }
            return resultado;
      }

      // comprobar si un String es Int
      private static boolean esInt(String s) {
            boolean resultado = true;
            for (int i = 0; i < s.length(); i++) {
                  if (!Character.isDigit(s.charAt(i))) {
                       resultado = false;
                       break; 
                  }
            }
            return resultado;
      }
}
