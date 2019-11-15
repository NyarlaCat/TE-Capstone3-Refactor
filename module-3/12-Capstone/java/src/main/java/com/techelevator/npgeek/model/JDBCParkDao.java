package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.model.interfaces.ParkDao;

@Component
public class JDBCParkDao implements ParkDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
		//Tested
		@Override
	    public List<Park> getAllParks() {
	        List<Park> parks = new ArrayList<>();
	        String parkSearchSql = "SELECT parkcode, parkname, state, acreage, elevationinfeet, milesoftrail,"
	        		+ "numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote,"
	        		+ "inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies FROM park";
	        SqlRowSet results = jdbcTemplate.queryForRowSet(parkSearchSql);
	        
	        while(results.next() ) {
				Park newPark = mapParkToRowSet(results);
				parks.add(newPark);
			}
	        
			return parks;
	        
	        
	    }
	    //Method to take in String and return a Park object by parkCode
		
		
	//Tested
	@Override
	public Park getParkByCode(String parkCode) {
		
		Park newPark= new Park();
        String parkSearchSql = "SELECT parkcode, parkname, state, acreage, elevationinfeet, milesoftrail,"
        		+ "numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote,"
        		+ "inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies FROM park "
        		+ "WHERE parkcode = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(parkSearchSql, parkCode);
        
        while(results.next() ) {
        	newPark = mapParkToRowSet(results);
		
		}
        
		return newPark;
		
	}

	@Override
	public List<Park> sortFavoritePark() {
		
		 List<Park> parks = new ArrayList<>();
	        String parkSearchSql = "SELECT count(survey result.parkcode) count, park.parkcode, park.parkname "
	        		             + "FROM survey_result "
	        		             + "JOIN park ON survey_result.parkcode = park.parkcode "
	        		             + "GROUP BY park.parkcode "
	        		             + "ORDER BY count DESC";
	        
	        SqlRowSet results = jdbcTemplate.queryForRowSet(parkSearchSql);
	        
	        while(results.next() ) {
				Park newPark = mapParkToRowSet(results);
				parks.add(newPark);
			}
	        
			return parks;
	}
	    
	
	
	private Park mapParkToRowSet(SqlRowSet results) {
		Park newPark = new Park();
		newPark.setParkCode(results.getString("parkcode"));
		newPark.setParkName(results.getString("parkname"));
		newPark.setState(results.getString("state"));
		newPark.setAcreage(results.getInt("acreage"));
		newPark.setElevationInFeet(results.getInt("elevationinfeet"));
		newPark.setMilesOfTrail(results.getDouble("milesoftrail"));
		newPark.setNumberOfCampsites(results.getInt("numberofcampsites"));
		newPark.setClimate(results.getString("climate"));
		newPark.setYearFounded(results.getInt("yearfounded"));
		newPark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		newPark.setInspirationalQuote(results.getString("inspirationalquote"));
		newPark.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		newPark.setParkDescription(results.getString("parkdescription"));
		newPark.setEntryFee(results.getInt("entryfee"));
		newPark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		
		return newPark;
	}
	

}
