import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;
  private StatisticsGUI stGUI;

	public StatisticsDisplay(Observable observable) {
		observable.addObserver(this);
    stGUI = new StatisticsGUI();
	}

	public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)observable;
			float temp = weatherData.getTemperature();
			tempSum += temp;
			numReadings++;

			if (temp > maxTemp) {
				maxTemp = temp;
			}
 
			if (temp < minTemp) {
				minTemp = temp;
			}

			display();
		}
	}

	public void display() {
		stGUI.label.setText("Avg/Max/Min temperature = " + WeatherStation.rounder((tempSum / numReadings))
			+ "/" + WeatherStation.rounder(maxTemp) + "/" + WeatherStation.rounder(minTemp));
	}
}