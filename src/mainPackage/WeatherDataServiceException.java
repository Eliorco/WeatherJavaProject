package mainPackage;

public class WeatherDataServiceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WeatherDataServiceException(){};
	
	public WeatherDataServiceException(String msg){
		super(msg);
	}
}
