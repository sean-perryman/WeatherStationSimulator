
import javax.swing.JOptionPane;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData wd = new WeatherData();
		WeatherConnector wc = new WeatherConnector(wd);
    
    //Instantiate the update window
    NewWeatherGUI nwGUI = new NewWeatherGUI(wd, wc);
    
    CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(wd);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(wd);
		ForecastDisplay forecastDisplay = new ForecastDisplay(wd);
    	
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
    JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
  }
}