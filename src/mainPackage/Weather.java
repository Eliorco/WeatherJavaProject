package mainPackage;

public class Weather {

	private  Integer weatherID;
	private  String weatherMain;
	private  String weatherDescription;
	private  String weatherIcon;
	private  Double mainTemp;
	private  Integer mainPressure;
	private  Integer mainHumidity;
	private  Double mainTempMin;
	private  Double mainTempMax;
	private  Double windSpeed;
	private  Integer windDeg;
	private  Integer cloudsAll;
	private  Long dt;
	
	public Weather(){
	}
	public Integer getWeatherID() {
		return weatherID;
	}
	public void setWeatherID(Integer weatherID) {
		this.weatherID = weatherID;
	}
	public String getWeatherMain() {
		return weatherMain;
	}
	public void setWeatherMain(String weatherMain) {
		this.weatherMain = weatherMain;
	}
	public String getWeatherDescription() {
		return weatherDescription;
	}
	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}
	public String getWeatherIcon() {
		return weatherIcon;
	}
	public void setWeatherIcon(String weatherIcon) {
		this.weatherIcon = weatherIcon;
	}
	public Double getMainTemp() {
		return mainTemp;
	}
	public void setMainTemp(Double mainTemp) {
		mainTemp = mainTemp  - 273.15;
		this.mainTemp = mainTemp;
	}
	public Integer getMainPressure() {
		return mainPressure;
	}
	public void setMainPressure(Integer mainPressure) {
		this.mainPressure = mainPressure;
	}
	public Integer getMainHumidity() {
		return mainHumidity;
	}
	public void setMainHumidity(Integer mainHumidity) {
		this.mainHumidity = mainHumidity;
	}
	public Double getMainTempMin() {
		return mainTempMin;
	}
	public void setMainTempMin(Double mainTempMin) {
		this.mainTempMin = mainTempMin - 273.15;
	}
	public Double getMainTempMax() {
		return mainTempMax;
	}
	public void setMainTempMax(Double mainTempMax) {
		this.mainTempMax = mainTempMax - 273.15;
	}
	public Double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public Integer getWindDeg() {
		return windDeg;
	}
	public void setWindDeg(Integer windDeg) {
		this.windDeg = windDeg;
	}
	public Integer getCloudsAll() {
		return cloudsAll;
	}
	public void setCloudsAll(Integer cloudsAll) {
		this.cloudsAll = cloudsAll;
	}
	public Long getDt() {
		return dt;
	}
	public void setDt(Long dt) {
		this.dt = dt;
	}
	
}
