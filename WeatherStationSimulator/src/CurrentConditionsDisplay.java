import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
	
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	Observable observable;
	private float temperature;
	private float humidity;
  private float windSpeed;
  private CurrentConditionsGUI ccGUI;
	
	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
    
    ccGUI = new CurrentConditionsGUI();
	}
	
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
      this.windSpeed = weatherData.getWindSpeed();
			display();
		}
	}
	
	public void display() {
    ccGUI.label.setText("Current conditions: " + temperature + "F degrees, " +
                        humidity + "% humidity, and wind speed: " + windSpeed + "MPH");
	}
}