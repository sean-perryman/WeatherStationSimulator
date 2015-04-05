import java.util.Observable;
import java.util.Observer;
	
public class WeatherData extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;
  private float windSpeed;
  private float windChill;
	
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
  
  public void setMeasurements(float temperature, float humidity, float pressure, float windSpeed, float windChill) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
    this.windSpeed = windSpeed;
    this.windChill = windChill;
		measurementsChanged();
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
  
  public float getWindSpeed() {
    return windSpeed;
  }
  
  public float getWindChill() {
    return windChill;
  }
}