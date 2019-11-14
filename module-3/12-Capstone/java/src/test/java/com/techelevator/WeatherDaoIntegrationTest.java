package com.techelevator;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

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
	
	//private helper to make fake weather
	private Weather makeFakeWeatherData(String parkCode) {
		Weather newWeather = new Weather();
		
		return newWeather;
	}
}
