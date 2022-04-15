package GUI.Frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.Componente.Celula;
import GUI.Componente.ThreadCelula;
import GUI.Comprobacion.Comprobacion;

public class Ventana {
      // metodo
      public Ventana(int largo, int ancho) {
            this.largo = largo;
            this.ancho = ancho;
      }

      // variable - Ventana
      ThreadCelula threadCelula = new ThreadCelula();
      private int largo; // el cantidad de botones del largo
      private int ancho; // el cantidad de botones del ancho
      private int velocidad = 500;
      private int veces = 0;
      private JFrame ventana = new JFrame("Juego de la vida (Iu y Hang)"); // la ventana principal grafica
      private JPanel cartas = new JPanel();
      private CardLayout cardlayout = new CardLayout(); // el layout de la ventana
      private String panel_actual = "home"; // guardar el nombre del panel actual, por defecto "home"
      private JPanel panel_home = new JPanel(); // el panel "home" que esta en la ventana principal
      private JPanel panel_setting = new JPanel(); // el panel "setting" que esta en la ventana principal
      private JPanel panel_game = new JPanel(); // el panel "game" que esta en la ventana principal
      private Color color_fondo = Color.decode("#4488C1");
      private Color color_button = Color.decode("#D07971");
      private Color color_texto = Color.white;

      // variable - panel_home
      private BoxLayout boxlayout_home = new BoxLayout(panel_home, BoxLayout.Y_AXIS); // el layout del panel_home
      private Box box_home = Box.createVerticalBox();
      private Box box_play_home = Box.createHorizontalBox();
      private JButton button_play_home = new JButton("Play");
      private Box box_setting_home = Box.createHorizontalBox();
      private JButton button_setting_home = new JButton("Setting");
      private Box box_exit_home = Box.createHorizontalBox();
      private JButton button_exit_home = new JButton("Exit");
      private Dimension size_button_home = new Dimension(85, 35);

      // variable - panel_setting
      private BoxLayout boxlayout_setting = new BoxLayout(panel_setting, BoxLayout.Y_AXIS); // el layout del panel_setting

      private JPanel panel_width_setting = new JPanel(); // el panel de la configuracion de "width"
      private JLabel label_width_setting = new JLabel("Width:"); // el texto de la configuracion de "width"
      private JTextField textfield_width_setting = new JTextField("80");// el campo de texto de la configuracion de "width"

      private JPanel panel_height_setting = new JPanel(); // el panel de la configuracion de "height"
      private JLabel label_height_setting = new JLabel("Height:"); // el texto de la configuracion de "height"
      private JTextField textfield_height_setting = new JTextField("50"); // el campo de texto de la configuracion de "height"

      private JPanel panel_speed_setting = new JPanel(); // el panel de la configuracion  de "speed"
      private JLabel label_speed_setting = new JLabel("Speed:"); // el texto de la configuracion de "speed"
      private JTextField textfield_speed_setting = new JTextField("500"); // el campo de texto de la configuracion de "speed"

      private JPanel panel_times_setting = new JPanel(); // el panel de la configuracion de "times"
      private JLabel label_times_setting = new JLabel("Times:"); // el texto de la configuracion de "times"
      private JTextField textfield_times_setting = new JTextField("0"); // el campo de texto de la configuracion de "times"

      private JPanel panel_buttons_setting = new JPanel(); // el panel de los botones (Back, Save)
      private JButton button_back_setting = new JButton("Back"); // el boton de "back"
      private JButton button_save_setting = new JButton("Save"); // el boton de "save"

      // variable - panel_game
      private JPanel panel_north_game = new JPanel(); // el panel de arriba del panel_game
      private Box box_north_game = Box.createHorizontalBox(); // el box de los botones, esta dentro de panel_north_game
      private JButton button_pause_game = new JButton("Start"); // el boton "stop" del panel_game
      private JButton button_setting_game = new JButton("Setting"); // el boton "setting" del panel_game
      private JButton button_home_game = new JButton("Home"); // el boton "home" del panel_game
      public int times_game = 0; // cuantas generaciones ha pasado
      private JButton button_times_game = new JButton("" + times_game);
      private JPanel panel_center_game = new JPanel(); // el panel de abajo del panel_game
      private Celula[][] celulas;

      /**
       * Crear la ventana, todo configurado
       * incluido: paneles, listeners, 
       */
      public void crearVentana() {
            // configurar la ventana
            ventana.setSize(401, 224); // configurar el tamaño de la ventana
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // configurar la accion de hacer clic en X
            ventana.setVisible(true); // ventana visible
            ventana.setResizable(false);
            ventana.add(cartas);

            // configurar el panel "cartas"
            cartas.setLayout(cardlayout);

            // añadir los componentes a la ventana
            cartas.add(panel_home, "home");
            cartas.add(panel_setting, "setting");
            cartas.add(panel_game, "game");

            // cargar el panel Home
            cargarHome();
            // cargar el panel Setting
            cargarSetting();
            // cargar el panel Game
            cargarGame();
      }

      /**  
       * Cargar el panel_home cuando inicia el programa
       */
      private void cargarHome() {
            // configurar el panel_home
            panel_home.setLayout(boxlayout_home);
            panel_home.setBackground(Color.white);

            // añadir los componentes al panel_home
            panel_home.add(box_home);
            panel_home.setBackground(color_fondo);

            // añadir los componentes al box_home
            box_home.add(Box.createVerticalStrut(25));
            box_home.add(box_play_home);
            box_home.add(Box.createVerticalStrut(20));
            box_home.add(box_setting_home);
            box_home.add(Box.createVerticalStrut(20));
            box_home.add(box_exit_home);
            box_home.add(Box.createVerticalStrut(20));

            // añadir los componentes al box_play_home, box_setting_home y box_exit_home
            box_play_home.add(Box.createHorizontalStrut(150));
            box_play_home.add(button_play_home);
            box_play_home.add(Box.createHorizontalStrut(150));

            box_setting_home.add(Box.createHorizontalStrut(150));
            box_setting_home.add(button_setting_home);
            box_setting_home.add(Box.createHorizontalStrut(150));

            box_exit_home.add(Box.createHorizontalStrut(150));
            box_exit_home.add(button_exit_home);
            box_exit_home.add(Box.createHorizontalStrut(150));

            // configurar el button_play_home
            button_play_home.setPreferredSize(size_button_home);
            button_play_home.setBackground(color_button);
            button_play_home.setForeground(color_texto);

            // configurar el button_setting_home
            button_setting_home.setPreferredSize(size_button_home);
            button_setting_home.setBackground(color_button);
            button_setting_home.setForeground(color_texto);

            // configurar el button_exit_home
            button_exit_home.setPreferredSize(size_button_home);
            button_exit_home.setBackground(color_button);
            button_exit_home.setForeground(color_texto);

            // añadir ActionListener a los botones
            button_play_home.addActionListener(new BotonGeneralListener());
            button_setting_home.addActionListener(new BotonGeneralListener());
            button_exit_home.addActionListener(new BotonGeneralListener());
      }

      /**
       * Cargar el panel_setting cuando inicia el programa
       */
      private void cargarSetting() {
            // configurar el panel_setting
            panel_setting.setBackground(color_fondo);
            panel_setting.setLayout(boxlayout_setting);

            // añadir los componentes a panel_setting
            panel_setting.add(Box.createVerticalStrut(10));
            panel_setting.add(panel_width_setting);
            panel_setting.add(panel_height_setting);
            panel_setting.add(panel_speed_setting);
            panel_setting.add(panel_times_setting);
            panel_setting.add(panel_buttons_setting);

            // configurar los paneles que estan dentro de panel_setting
            panel_width_setting.add(Box.createHorizontalBox());
            panel_height_setting.add(Box.createHorizontalBox());
            panel_speed_setting.add(Box.createHorizontalBox());
            panel_times_setting.add(Box.createHorizontalBox());
            panel_buttons_setting.add(Box.createHorizontalBox());
            panel_width_setting.setBackground(color_fondo);
            panel_height_setting.setBackground(color_fondo);
            panel_speed_setting.setBackground(color_fondo);
            panel_times_setting.setBackground(color_fondo);
            panel_buttons_setting.setBackground(color_fondo);


            // añadir los componenstes a los paneles
            panel_width_setting.add(label_width_setting);
            panel_width_setting.add(Box.createHorizontalStrut(15));
            panel_width_setting.add(textfield_width_setting);
            panel_height_setting.add(label_height_setting);
            panel_height_setting.add(Box.createHorizontalStrut(15));
            panel_height_setting.add(textfield_height_setting);
            panel_speed_setting.add(label_speed_setting);
            panel_speed_setting.add(Box.createHorizontalStrut(15));
            panel_speed_setting.add(textfield_speed_setting);
            panel_times_setting.add(label_times_setting);
            panel_times_setting.add(Box.createHorizontalStrut(15));
            panel_times_setting.add(textfield_times_setting);
            panel_buttons_setting.add(button_back_setting);
            panel_buttons_setting.add(Box.createHorizontalStrut(15));
            panel_buttons_setting.add(button_save_setting);

            // configurar los textos (label)
            label_width_setting.setForeground(color_texto); // color de texto
            label_height_setting.setForeground(color_texto); // color de texto
            label_speed_setting.setForeground(color_texto); // color de texto
            label_times_setting.setForeground(color_texto); // color de texto

            // configurar los campos de texto (textfield)
            textfield_width_setting.setPreferredSize(new Dimension(50, 20)); // tamaño de texto
            textfield_width_setting.setHorizontalAlignment(0); // texto central
            textfield_width_setting.setBorder(BorderFactory.createEmptyBorder());
            textfield_height_setting.setPreferredSize(new Dimension(50, 20)); // tamaño de texto
            textfield_height_setting.setHorizontalAlignment(0); // texto central
            textfield_height_setting.setBorder(BorderFactory.createEmptyBorder());
            textfield_speed_setting.setPreferredSize(new Dimension(50, 20)); // tamaño de texto
            textfield_speed_setting.setHorizontalAlignment(0); // texto central
            textfield_speed_setting.setBorder(BorderFactory.createEmptyBorder());
            textfield_times_setting.setPreferredSize(new Dimension(50, 20)); // tamaño de texto
            textfield_times_setting.setHorizontalAlignment(0); // texto central
            textfield_times_setting.setBorder(BorderFactory.createEmptyBorder());

            // configurar los botones
            button_back_setting.setBackground(color_button);
            button_save_setting.setBackground(color_button);
            button_back_setting.setForeground(color_texto);
            button_save_setting.setForeground(color_texto);
            button_back_setting.addActionListener(new BotonGeneralListener());
            button_save_setting.addActionListener(new BotonSaveListener());
      }

      /**
       * Cargar el panel_game cuando inicia el programa
       */
      private void cargarGame() {
            // añadir los paneles al panel_game
            panel_game.setLayout(new BorderLayout());
            panel_game.add(panel_north_game, BorderLayout.NORTH);
            panel_game.add(panel_center_game, BorderLayout.CENTER);

            // configurar el panel_north_game
            panel_north_game.add(box_north_game);
            panel_north_game.setBackground(color_fondo);

            // añadir los componentes al box_north_game
            box_north_game.add(button_pause_game);
            box_north_game.add(Box.createHorizontalStrut(10));
            box_north_game.add(button_setting_game);
            box_north_game.add(Box.createHorizontalStrut(10));
            box_north_game.add(button_home_game);
            box_north_game.add(Box.createHorizontalStrut(10));
            box_north_game.add(button_times_game);

            // configurar los botones de norte
            button_pause_game.setBackground(color_button);
            button_pause_game.setForeground(color_texto);
            button_pause_game.setEnabled(true);
            button_pause_game.addActionListener(new BotonStartGameListener());

            button_setting_game.setBackground(color_button);
            button_setting_game.setForeground(color_texto);
            button_setting_game.addActionListener(new BotonGeneralListener());

            button_home_game.setBackground(color_button);
            button_home_game.setForeground(color_texto);
            button_home_game.addActionListener(new BotonGeneralListener());
            
            button_times_game.setBackground(color_button);
            button_times_game.setForeground(color_texto);
            // button_home_game.addActionListener(new BotonGeneralListener());

            // configurar el panel_center_game
            panel_center_game.setLayout(null);
            
            // añadir y configurar los botoncitos al panel_center_game
            celulas = new Celula[largo][ancho]; // este paso no puede estar fuera por alguna razon rara
            for (int y = ancho - 1; y >= 0; y--) {
                  for (int x = 0; x < largo; x++) {
                        celulas[x][y] = new Celula();
                        panel_center_game.add(celulas[x][y]);
                        celulas[x][y].setBorderPainted(false);
                        celulas[x][y].setBounds(10 * x, 10 * y, 10, 10);
                        celulas[x][y].setBackground(Color.black);
                        celulas[x][y].addActionListener(new BotonArrayListener());
                  }
            }

            // configuracion de ThreadCelula
            threadCelula.start();
            threadCelula.setCelulas(celulas);
            threadCelula.setWidthAndHeight(largo, ancho);
            threadCelula.setSpeed(velocidad);
            threadCelula.setTimes(veces);
      }

      /**
       * Recargar el tablero de celulas
       * Se utiliza en caso de que el usuario ha modificado la configuracion
       */
      private void recargarTodoGame() {
            // recargar la parte de botones
            button_pause_game.setText("Start");
            button_times_game.setText("0");
            times_game = 0;

            // recargar la parte de ceculas
            panel_center_game.removeAll(); // quitar todos los componentes que estan en panel_center_game
            celulas = new Celula[largo][ancho]; // este paso no puede estar fuera por alguna razon rara
            for (int y = ancho - 1; y >= 0; y--) {
                  for (int x = 0; x < largo; x++) {
                        celulas[x][y] = new Celula();
                        panel_center_game.add(celulas[x][y]);
                        celulas[x][y].setBorderPainted(false);
                        celulas[x][y].setBounds(10 * x, 10 * y, 10, 10);
                        celulas[x][y].setBackground(Color.black);
                        celulas[x][y].addActionListener(new BotonArrayListener());
                  }
            }

            // configuracion de ThreadCelula
            threadCelula.pauseGame();
            threadCelula.setCelulas(celulas);
            threadCelula.setWidthAndHeight(largo, ancho);
            threadCelula.setSpeed(velocidad);
            threadCelula.setTimes(veces);            
      }

      private void recargarSpeedGame() {
            threadCelula.setSpeed(velocidad);
            threadCelula.setTimes(veces);
      }

      /** 
       * Limpiar el tablero de celulas, para que se vea como nuevo
       * Se utiliza en caso de que el usuario sale del juego al Menu
       */
      private void reiniciarGame() {
            // cambiar el texto de button_pause_game
            button_pause_game.setText("Start");
            button_times_game.setText("0");
            times_game = 0;

            // cambiar los colores de celulas a NEGRO
            for(int y = ancho - 1; y >= 0; y--) {
                  for (int x = 0; x < largo; x++) {
                        celulas[x][y].setBackground(Color.black);
                  }
            }

            // Pausar el juego
            threadCelula.pauseGame();
      }

      /** 
       * Hacer el cambio del panel y otro cambios
      */
      private void cambiarPanel(String name) {
            if (name == "home") {
                  if (panel_actual == "setting") {
                        cancelarConfiguracion(); // recuperar las modificaciones no guardados de configuracion (setting)
                  }
                  else if (panel_actual == "game") {
                        reiniciarGame(); // limpiar el tablero de celulas
                  }
                  cardlayout.show(cartas, "home"); // cambiar el panel
                  panel_actual = "home"; // guardar el nombre del panel
                  ventana.setSize(401, 224); // cambiar el tamaño
            }
            else if (name == "setting") {
                  if (panel_actual == "home") {
                        button_back_setting.setText("Home");
                  }
                  else if (panel_actual == "game") {
                        button_back_setting.setText("Back");
                        threadCelula.pauseGame();
                        button_pause_game.setText("Continue");
                  }
                  cardlayout.show(cartas, "setting"); // cambiar el panel
                  panel_actual = "setting"; // guardar el nombre del panel
                  ventana.setSize(401, 224); // cambiar el tamaño
            }
            else if (name == "game") {
                  if (panel_actual == "setting") {
                        cancelarConfiguracion(); // recuperar las modificaciones no guardados de configuracion (setting)
                  }
                  cardlayout.show(cartas, "game"); // cambiar el panel
                  panel_actual = "game"; // guardar el nombre del panel
                  ventana.setSize(largo * 10 + 16, ancho * 10 + 75); // cambiar el tamaño
            }
      }

      /**
       * Guardar las configuraciones
       */
      private void guardarConfiguracion() {
            largo = Integer.parseInt(textfield_width_setting.getText());
            ancho = Integer.parseInt(textfield_height_setting.getText());
            velocidad = Integer.parseInt(textfield_speed_setting.getText());
            veces = Integer.parseInt(textfield_times_setting.getText());
      }

      /**
       * Recuperar las modificaciones no guardados de configuracion
       */
      private void cancelarConfiguracion() {
            textfield_width_setting.setText(Integer.toString(largo));
            textfield_height_setting.setText(Integer.toString(ancho));
            textfield_speed_setting.setText(Integer.toString(velocidad));
            textfield_times_setting.setText(Integer.toString(veces));
      }

      public void registrarNumeroGeneracion() {
            times_game++;
            button_times_game.setText("" + times_game);
      }

      // ----------------------------- LISTENERS ----------------------------- // 

      // El listener para los botones comunes (Play, Setting, Home...)
      private class BotonGeneralListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                  JButton b = (JButton)e.getSource();
                  String button_name = b.getText();
                  if (button_name == "Setting") {
                        cambiarPanel("setting");
                  }
                  else if (button_name == "Home") {
                        cambiarPanel("home");
                  }
                  else if (button_name == "Play") {
                        cambiarPanel("game");
                  }
                  else if (button_name == "Back") {
                        cambiarPanel("game");
                  }
                  else if (button_name == "Exit") {
                        System.exit(0);
                  }
            }
      }

      // El listener para el array de botones de ceculas (cambiar el color cuando haga clic)
      private class BotonArrayListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                  JButton b = (JButton)e.getSource();
                  if (b.getBackground() == Color.white) {
                        b.setBackground(Color.black);
                  }
                  else {
                        b.setBackground(Color.white);
                  }
            }
      }

      // El listener para el boton "Save" del panel_setting
      private class BotonSaveListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                  if (Integer.parseInt(textfield_width_setting.getText()) == largo && Integer.parseInt(textfield_height_setting.getText()) == ancho) {
                        if (Comprobacion.EsSettingValido(textfield_width_setting.getText(), textfield_height_setting.getText(), textfield_speed_setting.getText(), textfield_times_setting.getText())) {
                              guardarConfiguracion();
                              recargarSpeedGame();
                        }
                        else {
                              cancelarConfiguracion();
                        }      
                  }
                  else {
                        if (Comprobacion.EsSettingValido(textfield_width_setting.getText(), textfield_height_setting.getText(), textfield_speed_setting.getText(), textfield_times_setting.getText())) {
                              guardarConfiguracion();
                              recargarTodoGame();
                        }
                        else {
                              cancelarConfiguracion();
                        }            
                  }
                  // si las configuraciones son validos, guardar la configuracion
                  // si no son validos, mostrar la configuración actual
            }
      }

      // El listener para el boton "Start" o "Pause"
      private class BotonStartGameListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                  JButton b = (JButton)e.getSource();
                  String name = b.getText();
                  if (name == "Start") {
                        threadCelula.continueGame(); // el hilo 2 continua
                        b.setText("Pause"); // cambiar el texto
                  }
                  else if (name == "Continue") {
                        threadCelula.continueGame(); // el hilo 2 continua
                        b.setText("Pause"); // cambiar el texto
                  }
                  else if (name == "Pause") {
                        threadCelula.pauseGame(); // el hilo 2 pausa
                        b.setText("Continue");// cambiar el texto
                  }
            }
      }
}