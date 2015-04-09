import javax.swing.*;

public class WindChillGUI {
  public JLabel label;
  
  public WindChillGUI() {
    JFrame frame = new JFrame("Wind Chill Index");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Add the label
    label = new JLabel("Wind Chill", SwingConstants.CENTER);
    frame.getContentPane().add(label);

    //Display the window.
    frame.pack();
    frame.setSize(310, 175);
    frame.setLocation(430, 700);
    frame.setVisible(true);
  }
}