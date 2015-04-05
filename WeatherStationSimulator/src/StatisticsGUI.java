import javax.swing.*;

public class StatisticsGUI {
  public JLabel label;
  
  public StatisticsGUI() {
    JFrame frame = new JFrame("Statistics");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Add the label
    label = new JLabel("Statistics", SwingConstants.CENTER);
    frame.getContentPane().add(label);

    //Display the window.
    frame.pack();
    frame.setSize(640, 175);
    frame.setLocation(100, 500);
    frame.setVisible(true);
  }
}