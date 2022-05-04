/**
 *  Interfaz de usuario del Juego de la Vida.
 */

package src.Ventana;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import src.Componentes.Celula;
import src.Componentes.ThreadCelula;

public class Ventana {
      // variable
      private String panel_actual = "home";
      private Color color_fondo = Color.decode("#4488C1");
      private Color color_button = Color.decode("#D07971");
      private Color color_texto = Color.white;

      // variable - Ventana
      private JFrame ventana = new JFrame("Juego de la Vida"); // la ventana de juego
      private JPanel panel_global = new JPanel();
      private CardLayout paneles = new CardLayout(); // el layout de la ventana. Contiene los paneles declarados a continuación.
      private JPanel panel_home = new JPanel(); // el panel "home"
      private JPanel panel_settings = new JPanel(); // el panel "settings"
      private JPanel panel_game = new JPanel(); // el panel "game"

      // variable - Home
      private Box box_home = Box.createVerticalBox();
      private Box box_play_home = Box.createHorizontalBox();
      private Box box_settings_home = Box.createHorizontalBox();
      private Box box_exit_home = Box.createHorizontalBox();
      private JButton button_play_home = new JButton("Play");
      private JButton button_settings_home = new JButton("Settings");
      private JButton button_exit_home = new JButton("Exit");

      // variable - Settings
      private JPanel panel_width_settings = new JPanel(); // el panel de la configuracion de "width"
      private JLabel label_width_settings = new JLabel(" Width:"); // el texto de la configuracion de "width"
      private JTextField textfield_width_settings = new JTextField("80");// el campo de texto de la configuracion de "width"

      private JPanel panel_height_settings = new JPanel(); // el panel de la configuracion de "height"
      private JLabel label_height_settings = new JLabel("Height:"); // el texto de la configuracion de "height"
      private JTextField textfield_height_settings = new JTextField("50"); // el campo de texto de la configuracion de "height"

      private JPanel panel_speed_settings = new JPanel(); // el panel de la configuracion  de "speed"
      private JLabel label_speed_settings = new JLabel("Speed:"); // el texto de la configuracion de "speed"
      private JTextField textfield_speed_settings = new JTextField("500"); // el campo de texto de la configuracion de "speed"

      private JPanel panel_times_settings = new JPanel(); // el panel de la configuracion de "times"
      private JLabel label_times_settings = new JLabel("Times:"); // el texto de la configuracion de "times"
      private JTextField textfield_times_settings = new JTextField("0"); // el campo de texto de la configuracion de "times"

      private JPanel panel_buttons_settings = new JPanel(); // el panel de los botones (Back, Save)
      private JButton button_back_settings = new JButton("Back"); // el boton de "back"
      private JButton button_save_settings = new JButton("Save"); // el boton de "save"

      private JPanel panel_aab_settings = new JPanel();
      private JLabel label_aab_settings = new JLabel("   AA/B:");
      private JTextField textfield_aab_settings = new JTextField("23/3"); 

      // variable - Game
      private int largo = 80;
      private int ancho = 50;
      private int velocidad = 500;
      private int veces_max = 0;
      private String AAB = "23/3";
      private ThreadCelula thread_celula = new ThreadCelula();
      private JPanel panel_north_game = new JPanel();
      private Box box_north_game = Box.createHorizontalBox();
      private JPanel panel_center_game = new JPanel();
      private JButton button_start_game = new JButton("Start");
      private JButton button_settings_game = new JButton("Settings");
      private JButton button_home_game = new JButton("Home");
      private JButton button_reset_game = new JButton("0");
      public int n_generacion = 0;
      private Celula[][] celulas;

      // ----------------------- INTERFAZ GRÁFICA -------------------------- //

      /* Crear la ventana completa del juego */
      public void crearVentana() {
            // configuración de la ventana
            ventana.setSize(401, 224); // Configurar el tamaño de la ventana
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la ventana finalizará la ejecución del programa.
            ventana.setVisible(true); // Configurar la ventana como visible.
            ventana.setResizable(false); // No se va a poder redimensionar la ventana.
            ventana.add(panel_global); // Añadimos un panel a la ventana, que contendrá todos los elementos.
            
            // configuración del panel_global
            panel_global.setLayout(paneles); // Designarle el CardLayout al que hemos llamado "paneles"
            panel_global.add(panel_home, "home"); // Añadir el panel Home al panel global
            panel_global.add(panel_settings, "settings"); // Añadir el panel Settings al panel global
            panel_global.add(panel_game, "game"); // Añadir el panel Game al panel global

            // crear panel_home
            crearHome();

            // crear panel_settings
            crearSettings();

            // crear panel_game
            crearGame();
      }

      /* Crear el panel_home */
      private void crearHome() {
            // configuración del panel_home
            panel_home.setLayout(new BoxLayout(panel_home, BoxLayout.Y_AXIS));
            panel_home.setBackground(color_fondo);
            panel_home.add(box_home);

            // configuración del box_home
            box_home.add(Box.createVerticalStrut(25));
            box_home.add(box_play_home);
            box_home.add(Box.createVerticalStrut(25));
            box_home.add(box_settings_home);
            box_home.add(Box.createVerticalStrut(25));
            box_home.add(box_exit_home);

            // configuración del boxes
            box_play_home.add(button_play_home);
            box_settings_home.add(button_settings_home);
            box_exit_home.add(button_exit_home);

            // configuración de los botones
            button_play_home.setBackground(color_button);
            button_play_home.setForeground(color_texto);
            button_play_home.addActionListener(new ListenerBotonesGenerales());
            button_settings_home.setBackground(color_button);
            button_settings_home.setForeground(color_texto);
            button_settings_home.addActionListener(new ListenerBotonesGenerales());
            button_exit_home.setBackground(color_button);
            button_exit_home.setForeground(color_texto);
            button_exit_home.addActionListener(new ListenerBotonesGenerales());
      }

      /* Crear el panel_settings */
      private void crearSettings() {
            // configuración del panel_settings
            panel_settings.setLayout(new BoxLayout(panel_settings, BoxLayout.Y_AXIS));
            panel_settings.setBackground(color_fondo);
            panel_settings.add(panel_width_settings);
            panel_settings.add(panel_height_settings);
            panel_settings.add(panel_speed_settings);            
            panel_settings.add(panel_times_settings);
            panel_settings.add(panel_aab_settings);
            panel_settings.add(panel_buttons_settings);

            // configuración de los paneles
            panel_width_settings.add(Box.createHorizontalBox());
            panel_width_settings.add(label_width_settings);
            panel_width_settings.add(textfield_width_settings);
            panel_width_settings.setBackground(color_fondo);
            
            panel_height_settings.add(Box.createHorizontalBox());
            panel_height_settings.add(label_height_settings);
            panel_height_settings.add(textfield_height_settings);
            panel_height_settings.setBackground(color_fondo);
            
            panel_speed_settings.add(Box.createHorizontalBox());
            panel_speed_settings.add(label_speed_settings);
            panel_speed_settings.add(textfield_speed_settings);
            panel_speed_settings.setBackground(color_fondo);
            
            panel_times_settings.add(Box.createHorizontalBox());
            panel_times_settings.add(label_times_settings);
            panel_times_settings.add(textfield_times_settings);
            panel_times_settings.setBackground(color_fondo);
            
            panel_aab_settings.add(Box.createHorizontalBox());
            panel_aab_settings.add(label_aab_settings);
            panel_aab_settings.add(textfield_aab_settings);
            panel_aab_settings.setBackground(color_fondo);
            
            panel_buttons_settings.add(Box.createHorizontalBox());
            panel_buttons_settings.add(button_back_settings);
            panel_buttons_settings.add(button_save_settings);
            panel_buttons_settings.setBackground(color_fondo);

            // configuración de los labeles
            label_width_settings.setForeground(color_texto);
            label_height_settings.setForeground(color_texto);
            label_speed_settings.setForeground(color_texto);
            label_times_settings.setForeground(color_texto);
            label_aab_settings.setForeground(color_texto);

            // configuración de los campos de texto (TextField)
            textfield_width_settings.setPreferredSize(new Dimension(50, 20)); // tamaño de texto
            textfield_width_settings.setHorizontalAlignment(0); // texto central
            textfield_width_settings.setBorder(BorderFactory.createEmptyBorder());
            textfield_height_settings.setPreferredSize(new Dimension(50, 20)); // tamaño de texto
            textfield_height_settings.setHorizontalAlignment(0); // texto central
            textfield_height_settings.setBorder(BorderFactory.createEmptyBorder());
            textfield_speed_settings.setPreferredSize(new Dimension(50, 20)); // tamaño de texto
            textfield_speed_settings.setHorizontalAlignment(0); // texto central
            textfield_speed_settings.setBorder(BorderFactory.createEmptyBorder());
            textfield_times_settings.setPreferredSize(new Dimension(50, 20)); // tamaño de texto
            textfield_times_settings.setHorizontalAlignment(0); // texto central
            textfield_times_settings.setBorder(BorderFactory.createEmptyBorder());
            textfield_aab_settings.setPreferredSize(new Dimension(50, 20)); // tamaño de texto
            textfield_aab_settings.setHorizontalAlignment(0); // texto central
            textfield_aab_settings.setBorder(BorderFactory.createEmptyBorder());

            // configuración de los botones
            button_back_settings.setBackground(color_button);
            button_save_settings.setBackground(color_button);
            button_back_settings.setForeground(color_texto);
            button_save_settings.setForeground(color_texto);
            button_back_settings.addActionListener(new ListenerBotonesGenerales());
            button_save_settings.addActionListener(new ListenerBotonesGenerales());
      }

      /* Crear el panel_game */
      private void crearGame() {
            // configuración del panel_game
            panel_game.setLayout(new BorderLayout());
            panel_game.add(panel_north_game, BorderLayout.NORTH);
            panel_game.add(panel_center_game, BorderLayout.CENTER);

            // configuración del panel_north_game
            panel_north_game.setBackground(color_fondo);
            panel_north_game.add(box_north_game);

            // configuración del box_north_game
            box_north_game.add(button_start_game);
            box_north_game.add(Box.createHorizontalStrut(10));
            box_north_game.add(button_settings_game);
            box_north_game.add(Box.createHorizontalStrut(10));
            box_north_game.add(button_home_game);
            box_north_game.add(Box.createHorizontalStrut(10));
            box_north_game.add(button_reset_game);

            // configuración de los botones (start, settings, home)
            button_start_game.setBackground(color_button);
            button_start_game.setForeground(color_texto);
            button_start_game.setEnabled(true);
            button_start_game.addActionListener(new ListenerBotonesGenerales());
            button_settings_game.setBackground(color_button);
            button_settings_game.setForeground(color_texto);
            button_settings_game.addActionListener(new ListenerBotonesGenerales());
            button_home_game.setBackground(color_button);
            button_home_game.setForeground(color_texto);
            button_home_game.addActionListener(new ListenerBotonesGenerales());
            button_reset_game.setBackground(color_button);
            button_reset_game.setForeground(color_texto);

            // configuración del panel_center_game
            panel_center_game.setLayout(null);
            celulas = new Celula[largo][ancho];
            for (int y = ancho - 1; y >= 0; y--) {
                  for (int x = 0; x < largo; x++) {
                        celulas[x][y] = new Celula();
                        panel_center_game.add(celulas[x][y]);
                        celulas[x][y].setBorderPainted(false);
                        celulas[x][y].setBackground(Color.black);
                        celulas[x][y].setBounds(10 * x, 10 * y, 10, 10);
                        celulas[x][y].addActionListener(new ListenerCelulas());
                  }
            }

            //
            thread_celula.start();
            thread_celula.stopGame();
            thread_celula.configCelulas(celulas);
            thread_celula.configVelocidad(velocidad);
            thread_celula.configNumeroGeneracionMax(veces_max);
      }

      // ----------------------- AUXILIARES GLOBALES -------------------------- //

      /**
       * cambiar el panel y configurar otras cosas necesarias
       * @param name el nombre del panel que quiere cambiar
       */
      private void cambiarPanel(String name) {
            if (name == "home") {
                  // si el usuario cambia el panel de "game" a "home", reiniciar el juego
                  if (panel_actual == "game") {
                        reiniciarJuego();
                  }
                  paneles.show(panel_global, "home");
                  ventana.setSize(401, 224);
                  panel_actual = "home";
            }
            else if (name == "settings") {
                  if (panel_actual == "home") {
                        button_back_settings.setText("Home");
                  }
                  else if (panel_actual == "game") {
                        button_back_settings.setText("Back");
                        button_start_game.setText("Continue");
                        thread_celula.stopGame();
                  }
                  paneles.show(panel_global, "settings");
                  ventana.setSize(401, 224);
                  panel_actual = "settings";
            }
            else if (name == "game") {
                  paneles.show(panel_global, "game");
                  ventana.setSize((largo * 10) + 16, (ancho * 10) + 75);
                  panel_actual = "game";
            }
      }

      public void contarNumeroGeneracion() {
            n_generacion++;
            button_reset_game.setText("" + n_generacion);
      }

      // ----------------------- AUXILIARES SOBRE PANEL_SETTINGS -------------------------- //

      /** 
       * Guardar las configuraciones del settings 
       * Se ejecuta CUANDO:
       * 1. El usuario cambia las configuraciones y son válidos
      */
      private void guardarSettings() {
            ancho = Integer.parseInt(textfield_height_settings.getText());
            largo = Integer.parseInt(textfield_width_settings.getText());
            velocidad = Integer.parseInt(textfield_speed_settings.getText());
            veces_max = Integer.parseInt(textfield_times_settings.getText());
            AAB = textfield_aab_settings.getText();
      }

      /** 
       * Descartar las configuraciones del settings 
       * Se ejecuta CUANDO:
       * 1. El usuario cambia las configuraciones y NO son válidos
      */
      private void descartarSettings() {
            textfield_width_settings.setText(Integer.toString(largo));
            textfield_height_settings.setText(Integer.toString(ancho));
            textfield_speed_settings.setText(Integer.toString(velocidad));
            textfield_times_settings.setText(Integer.toString(veces_max));
            textfield_aab_settings.setText(AAB);
      }


      // ----------------------- AUXILIARES SOBRE PANEL_GAME -------------------------- //

      /**
       * Recargar el juego completo
       * Se ejecuta CUANDO:
       * 1. El usuario modifica las configuraciones cambiando el tamaño
       */
      private void recargarJuegoTodo() {
            button_start_game.setText("Start");
            button_reset_game.setText("0");
            n_generacion = 0;
            
            panel_center_game.removeAll();
            celulas = new Celula[largo][ancho];
            for (int y = ancho - 1; y >= 0; y--) {
                  for (int x = 0; x < largo; x++) {
                        celulas[x][y] = new Celula();
                        panel_center_game.add(celulas[x][y]);
                        celulas[x][y].setBorderPainted(false);
                        celulas[x][y].setBackground(Color.black);
                        celulas[x][y].setBounds(10 * x, 10 * y, 10, 10);
                        celulas[x][y].addActionListener(new ListenerCelulas());
                  }
            }

            thread_celula.configCelulas(celulas);
            thread_celula.configVelocidad(velocidad);
            thread_celula.configNumeroGeneracionMax(veces_max);
            Celula.configAAB(AAB);

      }

      /**
       * Recargar las configuraciones sin cambiar el tamaño
       * Se ejecuta CUANDO:
       * 1. El usuario modifica las configuraciones SIN cambiar el tamaño
       */
      private void recargarJuegoConfig() {
            thread_celula.configVelocidad(velocidad);
            thread_celula.configNumeroGeneracionMax(veces_max);
            Celula.configAAB(AAB);
      }

      /**
       * Limpiar el tablero de celulas para que se vea como nuevo
       * Se ejecuta CUANDO:
       * 1. El usuario cambia el panel de "game" a "home"
       */
      private void reiniciarJuego() {
            button_start_game.setText("Start");
            button_reset_game.setText("0");
            n_generacion = 0;

            for (int y = ancho - 1; y >= 0; y--) {
                  for (int x = 0; x < largo; x++) {
                        celulas[x][y].setBackground(Color.black);
                  }
            }

            thread_celula.configNumeroGeneracionMax(veces_max);
      }


      // ------------------------------- LISTENERS ---------------------------------- //

      // El Listener para los botones
      private class ListenerBotonesGenerales implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                  JButton b = (JButton)e.getSource();

                  switch (b.getText()) {
                        case "Play":
                              cambiarPanel("game");
                              break;

                        case "Settings":
                              cambiarPanel("settings");
                              break;

                        case "Exit":
                              System.exit(0);
                              break;

                        case "Home":
                              cambiarPanel("home");
                              break;

                        case "Back":
                              cambiarPanel("game");
                              break;

                        case "Save":
                              // si el usuario no ha cambiado nada sobre tamaño (largo y ancho)...
                              if (Integer.parseInt(textfield_width_settings.getText()) == largo && Integer.parseInt(textfield_height_settings.getText()) == ancho) {
                                    // si las configuraciones son válidos
                                    if (Settings.esValido(textfield_width_settings.getText(), textfield_height_settings.getText(), textfield_speed_settings.getText(), textfield_times_settings.getText(), textfield_aab_settings.getText())) {
                                          guardarSettings();
                                          recargarJuegoConfig();
                                    }
                                    //
                                    else {
                                          JOptionPane.showMessageDialog(ventana, "Wrong settings. Minimum values:\n\n - Height: 20\n - Width: 30\n - Speed: 100");
                                          descartarSettings();
                                    }

                              }
                              // si el usuario ha cambiado el tamaño...
                              else {
                                    // si las configuraciones son válidos
                                    if (Settings.esValido(textfield_width_settings.getText(), textfield_height_settings.getText(), textfield_speed_settings.getText(), textfield_times_settings.getText(), textfield_aab_settings.getText())) {
                                          guardarSettings();
                                          recargarJuegoTodo();
                                    }
                                    //
                                    else {
                                          JOptionPane.showMessageDialog(ventana, "Wrong settings. Minimum values:\n\n - Height: 20\n - Width: 30\n - Speed: 100");
                                          descartarSettings();
                                    }
                              }

                              break;

                        // Game
                        case "Start":
                              thread_celula.startGame();
                              button_start_game.setText("Pause");
                              break;

                        case "Pause":
                              thread_celula.stopGame();
                              button_start_game.setText("Continue");
                              break;

                        case "Continue":
                              thread_celula.startGame();
                              button_start_game.setText("Pause");
                              break;
                  }                  
            }
      }

      // El listener para las células
      private class ListenerCelulas implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                  JButton c = (JButton)e.getSource();
                  if (c.getBackground() == Color.BLACK) {
                        c.setBackground(Color.WHITE);
                  }
                  else {
                        c.setBackground(Color.BLACK);
                  }
            }
      }
}