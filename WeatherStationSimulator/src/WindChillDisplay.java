import java.util.Observable;
import java.util.Observer;

public class WindChillDisplay implements Observer, DisplayElement {
  float windChill = 0.0f;
  WindChillGUI wcGUI;
  
  public WindChillDisplay(Observable observable) {
    observable.addObserver(this);
    wcGUI = new WindChillGUI();
  }
  
  public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
      //Pull data from WeatherData object to variables
      WeatherData weatherData = (WeatherData)observable;
      float t = weatherData.getTemperature();
      float ws = weatherData.getWindSpeed();
      
      //Calculate wind chill
      windChill = (float)(35.74 + 0.6215 * t + (0.4275 * t - 35.75) * Math.pow( ws, 0.16 ));
      
      //Display Wind Chill
      display();
    }
  }
  
  public void display() {
    wcGUI.label.setText("The wind chill index is " + windChill);
  }
}
