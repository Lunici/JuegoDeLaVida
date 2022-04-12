// package Test;

// import javax.swing.Box;
// import javax.swing.BoxLayout;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JPanel;

// import java.awt.CardLayout;
// import java.awt.Dimension;

// public class Test01 {

//       public static void main(String[] args) {
//             JFrame frame = new JFrame();
//             JPanel panel = new JPanel();
//             JButton play = new JButton("Play");
//             JButton setting = new JButton("Setting");
      

//             frame.setVisible(true);
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             frame.setLayout(new CardLayout());
//             frame.add(panel);

//             panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//             panel.add(play);
//             panel.add(Box.createVerticalStrut(10));
//             panel.add(setting);

//             play.setPreferredSize(new Dimension(50, 30));
//             setting.setPreferredSize(new Dimension(50,30));

//             frame.pack();
//       }
// }
