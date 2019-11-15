package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.model.JDBCSurveyDao;

public class SurveyDaoIntegrationTest extends DAOIntegrationTest{

	private JdbcTemplate jdbcTemplate;
	private JDBCSurveyDao surveyDao;
	
	@Before
	public void instanciateForTesting() {
		surveyDao = new JDBCSurveyDao(getDataSource());
		jdbcTemplate = new JdbcTemplate(getDataSource());

	}

	@Test
	public void testSaveSurveyMethod() {
		Park newPark = makeFakeParkInTheDataBase("ZXY", "I whatever");
		Survey newSurvey = makeSurvey(newPark.getParkCode());
		
		Survey savedSurvey = surveyDao.save(newSurvey);
		
		String expectedParkCode = newPark.getParkCode();
		String actualParkkCode = savedSurvey.getParkCode();
		
		Assert.assertEquals(expectedParkCode, actualParkkCode);
		
		
	}
	
	
	private Survey makeSurvey(String parkCode) {
		Survey newSurvey = new Survey();
		 
		newSurvey.setActivityLevel("Low");
		newSurvey.setEmail("jerry@hotmail.com");
		newSurvey.setParkCode(parkCode);
		newSurvey.setState("Texas");
		
		return newSurvey;
		
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
