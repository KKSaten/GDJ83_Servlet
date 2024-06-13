package com.lsw.home.weather;

import java.util.List;

public class WeatherService {
	
	private WeatherDAO weatherDAO;
	public WeatherService() {
		weatherDAO = new WeatherDAO(); 
	}
	
	//list를 가져오는 용도
	public List<WeatherDTO> getWeathers() { 
		List<WeatherDTO> ar = weatherDAO.getWeathers(); 
		
		return ar;
	}//getWeathers() 끝
	
	
	//detail을 가져오는 용도
	public WeatherDTO getDetail(WeatherDTO weatherDTO) { 
		try {
			weatherDTO = weatherDAO.getDetail(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			weatherDTO = null; //데이터를 발견하지 못했을 때 
		}
		
		return weatherDTO;
	}//getDetail() 끝
	
	//추가하는 메서드
	public WeatherDTO add(WeatherDTO weatherDTO) {
		try {
			weatherDTO = weatherDAO.add(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return weatherDTO;
		
	}//add() 끝

}
