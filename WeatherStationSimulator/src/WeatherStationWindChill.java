

public class WeatherStationWindChill {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
    HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
    WindChillDisplay windChillDisplay = new WindChillDisplay(weatherData);

		weatherData.setMeasurements(10, 40, 30.5f, 20);
		weatherData.setMeasurements(0, 30, 30.7f, 10);
		weatherData.setMeasurements(-10, 20, 29.8f, 15);
	}
}
