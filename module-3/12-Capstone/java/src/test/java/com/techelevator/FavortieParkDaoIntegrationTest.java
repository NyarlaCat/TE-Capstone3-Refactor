package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.FavoritePark;
import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.model.JDBCFavoriteParkDao;
import com.techelevator.npgeek.model.JDBCSurveyDao;

public class FavortieParkDaoIntegrationTest extends DAOIntegrationTest {

	private JdbcTemplate jdbcTemplate;
	private JDBCSurveyDao surveyDao;
	private JDBCFavoriteParkDao favoriteParkDao;
	
	@Before
	public void instansiateForTesting() {
		favoriteParkDao = new JDBCFavoriteParkDao(getDataSource());
		surveyDao = new JDBCSurveyDao(getDataSource());
		jdbcTemplate = new JdbcTemplate(getDataSource());
		
	}
	@Test
	public void testGetFavoriteParksWorksAsExpected() {
		List<FavoritePark> favPark = favoriteParkDao.getTopVotedParks();
		int listSizeBefore = favPark.size();
		
		Park newPark1 = makeFakeParkInTheDataBase("KWP", "Kennywood Park");
		Park newPark2 = makeFakeParkInTheDataBase("IDW", "Idlewild Park");
		Park newPark3 = makeFakeParkInTheDataBase("JSNP", "Jelly Stone National Park");
		
		/* This is the same as a single line of the following block 
		String parkCode = newPark1.getParkCode();
		Survey fakeSurvey = makeSurvey(parkCode);
		Survey fakeSurveyWithId = surveyDao.save(fakeSurvey);
		*/
		
		Survey newSurvey1 = surveyDao.save(makeSurvey(newPark1.getParkCode()));
		Survey newSurvey2 = surveyDao.save(makeSurvey(newPark1.getParkCode()));
		Survey newSurvey3 = surveyDao.save(makeSurvey(newPark1.getParkCode()));
		Survey newSurvey4 = surveyDao.save(makeSurvey(newPark2.getParkCode()));
		Survey newSurvey5 = surveyDao.save(makeSurvey(newPark2.getParkCode()));
		Survey newSurvey6 = surveyDao.save(makeSurvey(newPark3.getParkCode()));
		
		List<FavoritePark> favParkAfter = favoriteParkDao.getTopVotedParks();
		int listSizeAfter = favParkAfter.size();
		int expectedListSize =  listSizeBefore + 3;
		
		Assert.assertEquals("List sizes are not as expect", expectedListSize, listSizeAfter);
		
		FavoritePark fav1 = new FavoritePark();
		FavoritePark fav2 = new FavoritePark();
		FavoritePark fav3 = new FavoritePark();

		for (FavoritePark park : favParkAfter) {
			if (park.getParkCode().equals(newPark1.getParkCode())) {
				fav1 = park;
			} else if (park.getParkCode().equals(newPark2.getParkCode())){
				fav2 = park;
			} else if (park.getParkCode().equals(newPark3.getParkCode())){
				fav3 = park;
			}
			
		}
		int expectedCount1 = 3;
		int expectedCount2 = 2;
		int expectedCount3 = 1;
		
		int actualCount1 = fav1.getCount();
		int actualCount2 = fav2.getCount();
		int actualCount3 = fav3.getCount();
		
		Assert.assertEquals("Count 1 not as expected", expectedCount1, actualCount1);
		Assert.assertEquals("Count 2 not as expected", expectedCount2, actualCount2);
		Assert.assertEquals("Count 3 not as expected", expectedCount3, actualCount3);


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
