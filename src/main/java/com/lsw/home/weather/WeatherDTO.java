package com.lsw.home.weather;

public class WeatherDTO {

	private String city;
	private double temperature;
	private String status;
	private int huminity;
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getHuminity() {
		return huminity;
	}
	public void setHuminity(int huminity) {
		this.huminity = huminity;
	}
	
	
	
}
