package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
	
	
			 List<FavoritePark> parks = new ArrayList<>();
		        String parkSearchSql = "SELECT count(survey_result.parkcode) count, park.parkcode, park.parkname "
		        		             + "FROM survey_result "
		        		             + "JOIN park ON survey_result.parkcode = park.parkcode "
		        		             + "GROUP BY park.parkcode "
		        		             + "ORDER BY count DESC";
		        
		        SqlRowSet results = jdbcTemplate.queryForRowSet(parkSearchSql);
		        
		        while(results.next() ) {
					FavoritePark newPark = mapParkToRowSet(results);
					parks.add(newPark);
				}
		        
				return parks;
		}
		    
	private FavoritePark mapParkToRowSet(SqlRowSet results) {
		FavoritePark favPark = new FavoritePark();
		favPark.setParkCode(results.getString("parkcode"));
		favPark.setParkName(results.getString("parkname"));
		favPark.setCount(results.getInt("count"));
		
		return favPark;
	}
	

}
	

