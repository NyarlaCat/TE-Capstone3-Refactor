package com.techelevator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.model.JDBCParkDao;

 
public class ParkDaoIntegrationTest extends DAOIntegrationTest {
	private JdbcTemplate jdbcTemplate;
	private JDBCParkDao parkDao;
	
	@Before
	public void instanciateForTesting() {
		parkDao = new JDBCParkDao(getDataSource());
		jdbcTemplate = new JdbcTemplate(getDataSource());

	}
	
	@Test
	public void checkThatGetAllParksWorksAndReturnsAList() {
		List<Park> parkList = parkDao.getAllParks();
		
		int listSizeBefore = parkList.size();
		
		Park park1 = makeFakeParkInTheDataBase("JDC", "Joe Desert Clif");
		Park park2 = makeFakeParkInTheDataBase("HJK", "Holy Jackelope Kids");
		
		parkList.add(park1);
		parkList.add(park2);
		
		
		int expectedSize = listSizeBefore + 2;
	
		int actualSize = parkList.size();
		
		Assert.assertEquals(expectedSize, actualSize);
		
		
	}
	
	@Test
	public void getParkByCodeWorksToReturnTheExpectedPark() {
		Park newPark = makeFakeParkInTheDataBase("LBZJ", "Linden BeeZ Johnson");
		
		Park parkReturnedByMethod = parkDao.getParkByCode("LBZJ");
		
		String expectedName = newPark.getParkName();
		String actualNameReturnedByMethod = parkReturnedByMethod.getParkName();
		
		Assert.assertEquals(expectedName, actualNameReturnedByMethod);
		
		
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
