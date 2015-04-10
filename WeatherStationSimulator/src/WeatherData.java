import java.util.Observable;
import java.util.Observer;
	
public class WeatherData extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;
  private float windSpeed;
	
	public WeatherData() { }
	
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
	
  public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
  
	public void setMeasurements(float temperature, float humidity, float pressure, float windSpeed) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
    this.windSpeed = windSpeed;
		measurementsChanged();
	}
	
	public float getTemperature() {
		return WeatherStation.rounder(temperature);
	}
	
	public float getHumidity() {
		return WeatherStation.rounder(humidity);
	}
	
	public float getPressure() {
		return WeatherStation.rounder(pressure);
	}
  
  public float getWindSpeed() {
    return WeatherStation.rounder(windSpeed);
  }
}
