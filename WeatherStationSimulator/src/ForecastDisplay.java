import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
	private float currentPressure = 29.92f;  
	private float lastPressure;
  private ForecastGUI fcGUI;

	public ForecastDisplay(Observable observable) {
		observable.addObserver(this);
    fcGUI = new ForecastGUI();
	}

	public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)observable;
			lastPressure = currentPressure;
			currentPressure = weatherData.getPressure();
			display();
		}
	}

	public void display() {
		String forecastString = "Forecast: ";
		if (currentPressure > lastPressure) {
			forecastString += "Improving weather on the way!";
		} else if (currentPressure == lastPressure) {
			forecastString += "More of the same";
		} else if (currentPressure < lastPressure) {
			forecastString += "Watch out for cooler, rainy weather";
		}
    
    //Update GUI window with forecast
    fcGUI.label.setText(forecastString);
	}
}