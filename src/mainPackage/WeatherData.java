package mainPackage;

public class WeatherData {
	
	Weather	curWeather = new Weather();
	Location curLocation = new Location();

	public Weather getCurWeather() {
		return curWeather;
	}
	public void setCurWeather(Weather curWeather) {
		this.curWeather = curWeather;
	}
	public Location getCurLocation() {
		return curLocation;
	}
	public void setCurLocation(Location curLocation) {
		this.curLocation = curLocation;
	}
	public WeatherData() {
		
	}
	public void setWeatherData(WeatherData copy) {
		this.curWeather = copy.curWeather;
		this.curLocation = copy.curLocation;
	}
}
