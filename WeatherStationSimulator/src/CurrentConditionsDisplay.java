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
			this.temperature = WeatherStation.rounder(weatherData.getTemperature());
			this.humidity = WeatherStation.rounder(weatherData.getHumidity());
      this.windSpeed = WeatherStation.rounder(weatherData.getWindSpeed());
			display();
		}
	}
	
	public void display() {
    ccGUI.label.setText("Current conditions: " + temperature + "F degrees, " +
                        humidity + "% humidity, and wind speed: " + windSpeed + "MPH");
	}
}