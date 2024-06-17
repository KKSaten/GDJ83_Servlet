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
	public void add(WeatherDTO weatherDTO) {
		try {
			weatherDAO.add(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//생각해보니까 add, delete, update 등의 메서드는 리턴을 할 필요가 없다
		//요녀석들의 기능 자체가 파일에 대한 내용의 수정일뿐이고 값을 가져와서 보여주는 것은
		//위의 getList 메서드와 getDetail 메서드이므로 얘네만 리턴값을 받으면 된다.
		
	}//add() 끝

	
	public List<WeatherDTO> delete(WeatherDTO weatherDTO) {
		List<WeatherDTO> ar = null;
		try {
			weatherDAO.delete(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
	
	
	public void update(WeatherDTO weatherDTO) {
		try {
			weatherDAO.update(weatherDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
