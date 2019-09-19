package mainPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherServiceDataTest {

	Location loc;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		loc = new Location("bat yam","israel");
	}

	@After
	public void tearDown() throws Exception {
		loc= null;
	}

	@Test
	public void testGetWeatherData() {
		WeatherData expected  = new WeatherData();
		WeatherData actual  = new WeatherData();
		OpenWeatherMap actalServiceData = new OpenWeatherMap();
		
		expected.curLocation.setCod(200);
		expected.curLocation.setCoordLat(32.02);
		expected.curLocation.setCoordLon(34.75);
		expected.curWeather.setDt((long) 1441138197);
		expected.curLocation.setSysCountry("IL");
		expected.curLocation.setId(new Integer(295548).toString());
		expected.curLocation.setName("Bat Yam".toLowerCase());
		try {
			actual.setWeatherData(actalServiceData.getWeatherData(loc));
		} catch (WeatherDataServiceException e) {
			e.printStackTrace();
		}
		assertEquals(expected.curLocation.getCoordLat(), actual.curLocation.getCoordLat());
		assertEquals(expected.curLocation.getCoordLon(), actual.curLocation.getCoordLon());
		assertEquals(expected.curLocation.getCod(), actual.curLocation.getCod());
		assertEquals(expected.curLocation.getName().toLowerCase(), actual.curLocation.getName().toLowerCase());
		
	}

}
