package mainPackage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.swing.JFrame;


public class OpenWeatherMap implements IWeatherDataService {

	//Model
	@Override
	public WeatherData getWeatherData(Location location) throws WeatherDataServiceException {
		WeatherData curWeatherData = new WeatherData();
		
		try {
			URL request = new URL(("http://api.openweathermap.org/data/2.5/weather?q="+ location.getName()+","+location.getSysCountry()).replace(" ","%20"));
			InputStream stream =  request.openStream();
			InputStreamReader reader = new InputStreamReader(stream);
			
			JSONObject jsonOBJ =  (JSONObject)new JSONParser().parse(reader);
			
			curWeatherData.getCurLocation().setCod((Integer.valueOf(jsonOBJ.get("cod").toString())));
			if(curWeatherData.curLocation.getCod() == 404){
				throw new MalformedURLException();
			}
			
			JSONObject jsonCoord = (JSONObject) jsonOBJ.get("coord");
			curWeatherData.getCurLocation().setCoordLon(Double.valueOf(jsonCoord.get("lon").toString()));
			curWeatherData.getCurLocation().setCoordLat((Double)jsonCoord.get("lat"));
			
			JSONArray weatherArray = (JSONArray) jsonOBJ.get("weather");
			JSONObject jsonWeather = (JSONObject) weatherArray.get(0);
			curWeatherData.getCurWeather().setWeatherID((Integer.valueOf(jsonWeather.get("id").toString())));
			curWeatherData.getCurWeather().setWeatherMain((String) jsonWeather.get("main"));
			curWeatherData.getCurWeather().setWeatherDescription((String) jsonWeather.get("description"));
			curWeatherData.getCurWeather().setWeatherIcon((String) jsonWeather.get("icon"));
			
			JSONObject jsonMain = (JSONObject) jsonOBJ.get("main");
			curWeatherData.getCurWeather().setMainTemp(((Double) jsonMain.get("temp")));
			curWeatherData.getCurWeather().setMainPressure((Integer.valueOf(jsonMain.get("pressure").toString())));
			curWeatherData.getCurWeather().setMainHumidity((Integer.valueOf(jsonMain.get("humidity").toString())));
			curWeatherData.getCurWeather().setMainTempMin((Double.valueOf(jsonMain.get("temp_min").toString())));
			curWeatherData.getCurWeather().setMainTempMax((Double.valueOf(jsonMain.get("temp_max").toString())));
			
			JSONObject jsonWind = (JSONObject) jsonOBJ.get("wind");
			curWeatherData.getCurWeather().setWindSpeed((Double.valueOf(jsonWind.get("speed").toString())));
			
			curWeatherData.getCurWeather().setCloudsAll((Integer.valueOf(((JSONObject) jsonOBJ.get("clouds")).get("all").toString())));
			
			curWeatherData.getCurWeather().setDt((Long.valueOf(jsonOBJ.get("dt").toString())));
			
			JSONObject jsonSys = (JSONObject) jsonOBJ.get("sys");
			curWeatherData.getCurLocation().setSysType((Integer.valueOf(jsonSys.get("type").toString())));
			curWeatherData.getCurLocation().setSysID((Integer.valueOf(jsonSys.get("id").toString())));
			curWeatherData.getCurLocation().setSysMessage((Double.valueOf(jsonSys.get("message").toString())));
			curWeatherData.getCurLocation().setSysCountry((String) jsonSys.get("country"));
			curWeatherData.getCurLocation().setSysSunrise((Long) jsonSys.get("sunrise"));
			curWeatherData.getCurLocation().setSysSunset((Long) jsonSys.get("sunset"));
			
			curWeatherData.getCurLocation().setId(jsonOBJ.get("id").toString());
			curWeatherData.getCurLocation().setName((String) jsonOBJ.get("name"));
			curWeatherData.getCurLocation().setCod((Integer.valueOf(jsonOBJ.get("cod").toString())));
			
		} catch (MalformedURLException e) {
			if(curWeatherData.getCurLocation().getCod() == 404){
			JOptionPane.showMessageDialog(new JFrame() , "Please enter a valid City or Country", "Address ERROR", JOptionPane.ERROR_MESSAGE);
			}
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(new JFrame() , "No Internet Connection", "Connection ERROR", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return curWeatherData;
	}

}
