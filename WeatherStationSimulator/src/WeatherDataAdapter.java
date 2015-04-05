
import java.util.ArrayList;

public class WeatherDataAdapter { 
  WeatherData weatherData; 
  
  public WeatherDataAdapter(WeatherData weatherData) { 
    this.weatherData = weatherData; 
  } 

  public double getTemperature() { 
    return (double)weatherData.getTemperature(); 
  } 

  public double getPressure() { 
    return (double)weatherData.getPressure(); 
  } 

  public int getHumidity() { 
    return Math.round(weatherData.getHumidity()); 
  } 

  public int getWindSpeed() { 
    return Math.round(weatherData.getWindSpeed()); 
  }
  
  public WeatherData convertFromSQL( double t, double p, int h, int wS ) {
    WeatherData wd = new WeatherData();
    wd.setMeasurements((float)t, (float)h, (float)p, (float)wS);
    return wd;
  }
  
  public ArrayList convertToSQL( float t, float p, float h, float wS ) {
    ArrayList al = new ArrayList();
    
    al.add((double)t);
    al.add((double)p);
    al.add((int)h);
    al.add((int)wS);
    
    return al;
  }
}