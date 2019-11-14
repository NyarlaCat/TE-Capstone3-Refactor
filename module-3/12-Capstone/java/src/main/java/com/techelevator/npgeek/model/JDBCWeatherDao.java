package com.techelevator.npgeek.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.model.interfaces.WeatherDao;

@Component
public class JDBCWeatherDao implements WeatherDao{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> getWeatherByParkCode(String parkCode) {
		
		return null;
	}
	
	//private method of map SQL search to object

}
