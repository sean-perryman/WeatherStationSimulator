import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class NewWeatherGUI {
  public JButton update;
  private final WeatherConnector wc;
  
  public NewWeatherGUI(WeatherData wd, WeatherConnector wc) {
    this.wc = wc;
    
    JFrame frame = new JFrame("New Weather");
    Container c = frame.getContentPane();
    c.setLayout(new GridLayout(3,3));
    
    //Create button
    update = new JButton("Update");
    
    //Place button in the center of the frame
    c.add(new JPanel());
    c.add(new JPanel());
    c.add(new JPanel());
    c.add(new JPanel());
    c.add(update);
    c.add(new JPanel());
    c.add(new JPanel());
    c.add(new JPanel());
    c.add(new JPanel());
    
    //Create the button listener
    update.addActionListener((ActionEvent e) -> {
      //Update the data on screens
      //this.wc.getData();
      WeatherStation.updateGUI(wd, wc);
    });
    
    //Display the window.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setSize(640, 175);
    frame.setLocation(100, 900);
    frame.setVisible(true);
  }
}