import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class AddWeatherGUI {
  public JButton addRandom;
  private final WeatherConnector wc;
  
  public AddWeatherGUI(WeatherData wd, WeatherConnector wc) {
    this.wc = wc;
    
    JFrame frame = new JFrame("Add Weather");
    Container c = frame.getContentPane();
    c.setLayout(new GridLayout(3,3));
    
    //Create button
    addRandom = new JButton("Add Weather");
    
    //Place button in the center of the frame
    c.add(new JPanel());
    c.add(new JPanel());
    c.add(new JPanel());

    c.add(new JPanel());
    c.add(addRandom);
    c.add(new JPanel());

    c.add(new JPanel());
    c.add(new JPanel());
    c.add(new JPanel());
        
    addRandom.addActionListener((ActionEvent e) -> {
      //Update the data on screens
      //this.wc.getData();
      WeatherStation.addRandomData(wd, wc);
    });
    
    //Display the window.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setSize(310, 175);
    frame.setLocation(430, 900);
    frame.setVisible(true);
  }
}