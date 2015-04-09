
import java.util.Random;
import javax.swing.JOptionPane;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData wd = new WeatherData();
		WeatherConnector wc = new WeatherConnector(wd);
    
    //Instantiate the update window
    UpdateWeatherGUI nwGUI = new UpdateWeatherGUI(wd, wc);
    AddWeatherGUI awGUI = new AddWeatherGUI(wd, wc);
    
    CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(wd);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(wd);
		ForecastDisplay forecastDisplay = new ForecastDisplay(wd);
    HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(wd);
    WindChillDisplay windChillDisplay = new WindChillDisplay(wd);
    	
    updateGUI(wd, wc);
  }
  
  public static void updateGUI(WeatherData wd, WeatherConnector wc) {  
    Float[] data = wc.getData();
    if (data[0] == 9999) { 
      infoBox("Sorry, new new weather data available.", "Error");
      return;
    }
    wd.setMeasurements(data[0], data[1], data[2], data[3], data[4]);
  }
  
  public static void infoBox(String infoMessage, String titleBar) {
    JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
  }
  
  public static void addRandomData(WeatherData wd, WeatherConnector wc) {
    //Add a random value at runtime to display addition capability
    float t, p, h, wS;
    Random r = new Random();
    t = r.nextFloat() + r.nextInt(100);
    p = r.nextFloat() + r.nextInt(35);
    h = r.nextFloat() + r.nextInt(50);
    wS = r.nextFloat() + r.nextInt(25);
    if (wc.addData(t, p, h, wS)) { WeatherStation.infoBox("New weather data successfully added to database", "Success!"); }
    else { WeatherStation.infoBox("Failed to add new weather data to database.", "Failure!"); }
  }
}