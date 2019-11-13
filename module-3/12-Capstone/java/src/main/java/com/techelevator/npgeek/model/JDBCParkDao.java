package com.techelevator.npgeek.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.model.interfaces.ParkDao;

@Component
public class JDBCParkDao implements ParkDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDao(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Park> getAllParks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Park getParkByCode(String parkCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Park> sortFavoritePark() {
		// TODO Auto-generated method stub
		return null;
	}

}
