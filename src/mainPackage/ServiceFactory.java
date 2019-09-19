package mainPackage;

public class ServiceFactory {
	static enum services {OpenWeatherMap};
	services s;
	
	public IWeatherDataService getService(services ser) {
		switch (ser) {
		case OpenWeatherMap : 
			return new OpenWeatherMap();
			
		default :
			return new OpenWeatherMap();
			
		}
		
	}

}
