package com.lsw.home.weather;

import java.util.List;

public class WeatherService {
	
	private WeatherDAO weatherDAO;
	
	public WeatherService() {
		weatherDAO = new WeatherDAO(); 
	}
	
	public List<WeatherDTO> getWeathers() { 
		List<WeatherDTO> ar = weatherDAO.read(); 
		
		return ar;
	}	

}
