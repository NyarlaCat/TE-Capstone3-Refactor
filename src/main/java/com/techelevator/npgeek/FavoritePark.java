package com.techelevator.npgeek;

public class FavoritePark {

	private String parkName;
	private String parkCode;
	private int count;
	
	public String getImgCode() {
		String imgCode = parkCode.toLowerCase();
		return imgCode;
	}
	
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
