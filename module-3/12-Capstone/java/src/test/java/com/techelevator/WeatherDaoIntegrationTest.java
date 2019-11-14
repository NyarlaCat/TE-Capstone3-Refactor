package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.model.JDBCWeatherDao;

public class WeatherDaoIntegrationTest  extends DAOIntegrationTest{

	private JdbcTemplate jdbcTemplate;
	private JDBCWeatherDao weatherDao;
	
	@Before
	public void instanciateForTesting() {
		weatherDao = new JDBCWeatherDao(getDataSource());
		jdbcTemplate = new JdbcTemplate(getDataSource());
		}
	
	
	@Test
	public void testThatGetWeatherListByParkCodeWorksAsExpected() {
		Park newPark = makeFakeParkInTheDataBase("JKLOL", "Just Kidding");
		List<Weather> weatherList = new ArrayList<Weather>();
		
		Weather newWeather1 = makeFakeWeatherData("JKLOL", 1);
		Weather newWeather2 = makeFakeWeatherData("JKLOL", 2);
		Weather newWeather3 = makeFakeWeatherData("JKLOL", 3);
		Weather newWeather4 = makeFakeWeatherData("JKLOL", 4);
		Weather newWeather5 = makeFakeWeatherData("JKLOL", 5);
		
		weatherList.add(newWeather1);
		weatherList.add(newWeather2);
		weatherList.add(newWeather3);
		weatherList.add(newWeather4);
		weatherList.add(newWeather5);
		
		List<Weather> returnedByMethod = weatherDao.getWeatherByParkCode("JKLOL");
		
		int expectedSize = weatherList.size();
		int actualSize = returnedByMethod.size();
		
		Assert.assertEquals(expectedSize, actualSize);	
	}
	
	//private helper to make fake weather
	private Weather makeFakeWeatherData(String parkCode, int fiveDayValue) {
		Weather newWeather = new Weather();
	
		newWeather.setParkCode(parkCode);
		newWeather.setFiveDayForecastValue(fiveDayValue);
		newWeather.setHigh(70);
		newWeather.setLow(50);
		newWeather.setForecast("rain");
		
		String sqlInsert = "INSERT INTO weather(parkcode, fivedayforecastvalue, low, high, forecast) VALUES (?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sqlInsert, parkCode, fiveDayValue, newWeather.getLow(), newWeather.getHigh(), newWeather.getForecast());
				
		return newWeather;
	}
	
	private Park makeFakeParkInTheDataBase(String parkCode, String parkName) {
		Park newPark = new Park();
		
		newPark.setParkCode(parkCode);
		newPark.setParkName(parkName);
		newPark.setState("Texas");
		newPark.setAcreage(32832);
		newPark.setElevationInFeet(0);
		newPark.setMilesOfTrail(800.0);
		newPark.setNumberOfCampsites(20);
		newPark.setClimate("Temperate");
		newPark.setYearFounded(1900);
		newPark.setAnnualVisitorCount(3176941);
		newPark.setInspirationalQuote("inspirationalquote");
		newPark.setInspirationalQuoteSource("inspirationalquotesource");
		newPark.setParkDescription("parkdescription");
		newPark.setEntryFee(15);
		newPark.setNumberOfAnimalSpecies(500);
	
		String sqlInsert = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail,"
        		+ "numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote,"
        		+ "inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies)"
        		+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(sqlInsert, newPark.getParkCode(), newPark.getParkName(), newPark.getState(),newPark.getAcreage(),newPark.getElevationInFeet(),newPark.getMilesOfTrail(),newPark.getNumberOfCampsites(),newPark.getClimate(),newPark.getYearFounded(),newPark.getAnnualVisitorCount(),newPark.getInspirationalQuote(),newPark.getInspirationalQuoteSource(),newPark.getParkDescription(),newPark.getEntryFee(),newPark.getNumberOfAnimalSpecies());
		
		return newPark;
		}
}
