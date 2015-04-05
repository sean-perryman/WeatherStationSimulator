import javax.swing.*;

public class CurrentConditionsGUI {
  public JLabel label;
  
  public CurrentConditionsGUI() {
    JFrame frame = new JFrame("Current Conditions");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Add the label
    label = new JLabel("Current Conditions", SwingConstants.CENTER);
    frame.getContentPane().add(label);

    //Display the window.
    frame.pack();
    frame.setSize(640, 175);
    frame.setLocation(100, 100);
    frame.setVisible(true);
  }
}