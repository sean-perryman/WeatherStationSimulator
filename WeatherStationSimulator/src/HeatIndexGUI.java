import javax.swing.*;

public class HeatIndexGUI {
  public JLabel label;
  
  public HeatIndexGUI() {
    JFrame frame = new JFrame("Heat Index");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Add the label
    label = new JLabel("Heat Index", SwingConstants.CENTER);
    frame.getContentPane().add(label);

    //Display the window.
    frame.pack();
    frame.setSize(640, 175);
    frame.setLocation(100, 700);
    frame.setVisible(true);
  }
}