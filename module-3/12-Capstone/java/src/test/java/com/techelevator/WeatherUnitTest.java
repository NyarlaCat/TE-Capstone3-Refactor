package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.Weather;

public class WeatherUnitTest {

	private Weather weather;
	
	@Before
	public void instanciateForTesting() {
	 weather = new Weather();
	}
	
	
	@Test
	public void testConversionMethod() {
		
		weather.setHigh(60);
		weather.setLow(32);
		
		int actualHighConverted = weather.getFarenheightToCelsiusHigh();
		int actualLowConverted = weather.getFarenheightToCelsiusLow();
		
		int expectedHighConverted = 15;
		int expectedLowConverted = 0;
		
		Assert.assertEquals("Low not converted as expected", expectedLowConverted, actualLowConverted);
		Assert.assertEquals("High not converted as expected", expectedHighConverted, actualHighConverted);
	}
}
