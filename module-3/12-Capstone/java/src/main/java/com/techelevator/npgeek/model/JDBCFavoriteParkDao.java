package com.techelevator.npgeek.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.FavoritePark;
import com.techelevator.npgeek.model.interfaces.FavoriteParkDao;

@Component
public class JDBCFavoriteParkDao implements FavoriteParkDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCFavoriteParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}	

	@Override
	public List<FavoritePark> getTopVotedParks() {
		// TODO Auto-generated method stub
		return null;
	}

}
