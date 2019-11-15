package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.model.interfaces.WeatherDao;

@Component
public class JDBCWeatherDao implements WeatherDao{

	private JdbcTemplate jdbcTemplate;
 
	@Autowired
	public JDBCWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	//Tested
	@Override
	public List<Weather> getWeatherByParkCode(String parkCode) {
		
		List<Weather> weather = new ArrayList<>();
		
        String weatherSearchSql = "SELECT parkcode, fivedayforecastvalue, high, low, forecast, "
        					 + "CASE forecast WHEN 'partly cloudy' THEN 'partlyCloudy' ELSE forecast END as forecastImage "
        					 + "FROM weather "
        					 + "WHERE parkcode = ? "
        					 + "GROUP BY parkcode, fivedayforecastvalue "
        					 + "ORDER BY fivedayforecastvalue";
        
        SqlRowSet results = jdbcTemplate.queryForRowSet(weatherSearchSql, parkCode);
        
        
        while(results.next() ) {
			Weather newWeather = mapWeatherToRowSet(results);
			weather.add(newWeather);
		}
          
		return weather;
		
	}
	
	//private method of map SQL search to object
	
	private Weather mapWeatherToRowSet(SqlRowSet results) {
		Weather newWeather = new Weather();
		newWeather.setParkCode(results.getString("parkcode"));
		newWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		newWeather.setHigh(results.getInt("high"));
		newWeather.setLow(results.getInt("low"));
		newWeather.setForecast(results.getString("forecast"));
		newWeather.setForecastImage(results.getString("forecastImage"));
		
		return newWeather;
	}

}
