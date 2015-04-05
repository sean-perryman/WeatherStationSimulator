import javax.swing.*;

public class ForecastGUI {
  public JLabel label;
  
  public ForecastGUI() {
    JFrame frame = new JFrame("Forecast");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Add the label
    label = new JLabel("Forecast", SwingConstants.CENTER);
    frame.getContentPane().add(label);

    //Display the window.
    frame.pack();
    frame.setSize(640, 175);
    frame.setLocation(100, 300);
    frame.setVisible(true);
  }
}