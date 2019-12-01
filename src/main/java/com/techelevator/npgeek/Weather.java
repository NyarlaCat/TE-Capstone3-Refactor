package com.techelevator.npgeek;

public class Weather {

	private String parkCode;
	private int fiveDayForecastValue;
	private int low;
	private int high;
	private String forecast;
	private String forecastImage;
	
	public int getFarenheightToCelsiusLow() {
		int celsius = ((low-32)*5) /9;
		return celsius;
	}
	
	public int getFarenheightToCelsiusHigh() {
		int celsius = ((high-32)*5) /9;
		return celsius;
	}
	
	public String getForecastImage() {
		return forecastImage;
	}
	public void setForecastImage(String forecastImage) {
		this.forecastImage = forecastImage;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode; 
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	

}
