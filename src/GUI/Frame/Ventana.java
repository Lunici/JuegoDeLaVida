package GUI.Frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana {
      // metodo
      public Ventana(int largo, int ancho) {
            this.largo = largo;
            this.ancho = ancho;
      }

      // variable - Ventana
      private int largo; // el cantidad de botones del largo
      private int ancho; // el cantidad de botones del ancho
      private JFrame ventana = new JFrame("Juego de la vida (Iu y Hang)"); // la ventana principal grafica
      private JPanel cartas = new JPanel();
      private CardLayout cardlayout = new CardLayout(); // el layout de la ventana
      private JPanel panel_home = new JPanel(); // el panel "home" que esta en la ventana principal
      private JPanel panel_setting = new JPanel(); // el panel "setting" que esta en la ventana principal
      private JPanel panel_game = new JPanel(); // el panel "game" que esta en la ventana principal

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
      private JLabel label_width_setting = new JLabel(); // el texto de la configuracion de "width"
      private JTextField textfield_width_setting = new JTextField("80");// el campo de texto de la configuracion de "width"
      private JPanel panel_height_setting = new JPanel(); // el panel de la configuracion de "height"
      private JLabel label_height_setting = new JLabel(); // el texto de la configuracion de "height"
      private JTextField textfield_height_setting = new JTextField("50"); // el campo de texto de la configuracion de "height"
      private JPanel panel_speed_setting = new JPanel(); // el panel de la configuracion  de "speed"
      private JLabel label_speed_setting = new JLabel(); // el texto de la configuracion de "speed"
      private JTextField textfield_speed_setting = new JTextField(); // el campo de texto de la configuracion de "speed"
      private JPanel panel_times_setting = new JPanel(); // el panel de la configuracion de "times"
      private JLabel label_times_setting = new JLabel(); // el texto de la configuracion de "times"
      private JTextField textfile_times_setting = new JTextField(); // el campo de texto de la configuracion de "times"
      private JPanel panel_buttons_setting = new JPanel(); // el panel de los botones (Back, Save)
      private JButton button_back_setting = new JButton("Back"); // el boton de "back"
      private JButton button_save_setting = new JButton("Save"); // el boton de "save"

      // variable - panel_game
      private JPanel panel_north_game = new JPanel(); // el panel de arriba del panel_game
      private Box box_north_game = Box.createHorizontalBox(); // el box de los botones, esta dentro de panel_north_game
      private JButton button_pause_game = new JButton("Start"); // el boton "stop" del panel_game
      private JButton button_setting_game = new JButton("Setting"); // el boton "setting" del panel_game
      private JButton button_home_game = new JButton("Home"); // el boton "home" del panel_game
      private JPanel panel_center_game = new JPanel(); // el panel de abajo del panel_game
      private JButton[][] array_buttons;

      // creat la ventana de juego (todo configurado)
      public void crearVentana() {
            // configurar la ventana
            ventana.setSize(401, 224); // configurar el tamaño de la ventana
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // configurar la accion de hacer clic en X
            ventana.setVisible(true); // ventana visible
            ventana.setResizable(true);
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

      private void cargarHome() {
            // configurar el panel_home
            panel_home.setLayout(boxlayout_home);
            panel_home.setBackground(Color.white);

            // añadir los componentes al panel_home
            panel_home.add(box_home);
            panel_home.setBackground(Color.decode("#9cd6ff"));

            // añadir los componentes al box_home
            box_home.add(Box.createVerticalStrut(20));
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
            button_play_home.setBackground(Color.decode("#0086d1"));
            button_play_home.setForeground(Color.white);

            // configurar el button_setting_home
            button_setting_home.setPreferredSize(size_button_home);
            button_setting_home.setBackground(Color.decode("#0086d1"));
            button_setting_home.setForeground(Color.white);

            // configurar el button_exit_home
            button_exit_home.setPreferredSize(size_button_home);
            button_exit_home.setBackground(Color.decode("#0086d1"));
            button_exit_home.setForeground(Color.white);

            // añadir ActionListener a los botones
            button_play_home.addActionListener(new BotonGeneralListener());
            button_setting_home.addActionListener(new BotonGeneralListener());
            button_exit_home.addActionListener(new BotonGeneralListener());
      }

      private void cargarSetting() {
            panel_setting.add(new JButton(""));
      }

      private void cargarGame() {
            // añadir los paneles al panel_game
            panel_game.setLayout(new BorderLayout());
            panel_game.add(panel_north_game, BorderLayout.NORTH);
            panel_game.add(panel_center_game, BorderLayout.CENTER);

            // configurar el panel_north_game
            panel_north_game.add(box_north_game);
            panel_north_game.setBackground(Color.decode("#9cd6ff"));

            // añadir los componentes al box_north_game
            box_north_game.add(button_pause_game);
            box_north_game.add(Box.createHorizontalStrut(10));
            box_north_game.add(button_setting_game);
            box_north_game.add(Box.createHorizontalStrut(10));
            box_north_game.add(button_home_game);

            // configurar los botones de norte
            button_pause_game.setBackground(Color.decode("#0086d1"));
            button_pause_game.setForeground(Color.white);

            button_setting_game.setBackground(Color.decode("#0086d1"));
            button_setting_game.setForeground(Color.white);
            button_setting_game.addActionListener(new BotonGeneralListener());

            button_home_game.setBackground(Color.decode("#0086d1"));
            button_home_game.setForeground(Color.white);
            button_home_game.addActionListener(new BotonGeneralListener());

            // configurar el panel_center_game
            panel_center_game.setLayout(null);
            
            // añadir y configurar los botoncitos al panel_center_game
            array_buttons = new JButton[largo][ancho]; // este paso no puede estar fuera por alguna razon rara
            for (int x = 0; x < largo; x++) {
                  for (int y = 0; y < ancho; y++) {
                        array_buttons[x][y] = new JButton();
                        panel_center_game.add(array_buttons[x][y]);
                        array_buttons[x][y].setBorderPainted(false);
                        array_buttons[x][y].setBounds(10 * x, 10 * y, 10, 10);
                        array_buttons[x][y].setBackground(Color.white);
                        array_buttons[x][y].addActionListener(new BotonArrayListener());
                  }
            }
            // for (int y = ancho - 1; y >= 0; y--) {
            //       for (int x = 0; x < largo; x++) {
            //             array_buttons[x][y] = new JButton();
            //             array_buttons[x][y].setBorderPainted(false);
            //             array_buttons[x][y].setBounds(10 * x, 10 * (ancho - y - 1), 10, 10);
            //             array_buttons[x][y].setBackground(Color.white);
            //             array_buttons[x][y].addActionListener(new BotonArrayListener());
            //             panel_center_game.add(array_buttons[x][y]);
            //       }
            // }
      }

      public void reiniciarGame() {

      }

      private void cambiarPanel(String name) {
            if (name == "home") {
                  cardlayout.show(cartas, "home");
                  ventana.setSize(401, 224);
            }
            else if (name == "setting") {
                  cardlayout.show(cartas, "setting");
            }
            else if (name == "game") {
                  cardlayout.show(cartas, "game");
                  ventana.setSize(largo * 10 + 16, ancho * 10 + 79);
            }
      }

      // el listener para los botones comunes
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
                  else if (button_name == "Exit") {
                        System.exit(0);
                  }
            }
      }

      // el listener para el array de botones de ceculas (cambiar el color cuando haga clic)
      public class BotonArrayListener implements ActionListener {
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
}