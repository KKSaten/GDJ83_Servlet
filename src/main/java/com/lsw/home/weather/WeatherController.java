package com.lsw.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lsw.home.Action;

public class WeatherController {
	
	private WeatherService wc;
	public WeatherController() {
		wc = new WeatherService();
	}
	

	public Action start(HttpServletRequest request) {
		// /weather/모시꺵
		//list => 날씨정보전체출력
		//add => 날씨정보추가
		//delete => 날씨정보삭제
		//detail => 날씨정보출력
		
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"));
		
		Action action = new Action();
		action.setFlag(true);
		
		//method 형식을 반환 받자
		String method = request.getMethod().toUpperCase();
		
		
		if(uri.equals("/list")) {
			List<WeatherDTO> ar = wc.getWeathers();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/weather/list.jsp");
		}else if(uri.equals("/add")) {
			
			if(method.equals("POST")) {
				String city = request.getParameter("city");
				double temperature = Double.parseDouble(request.getParameter("temperature"));
				String status = request.getParameter("status");
				int huminity = Integer.parseInt(request.getParameter("huminity"));
				
				WeatherDTO weatherDTO = new WeatherDTO();
				weatherDTO.setCity(city);
				weatherDTO.setTemperature(temperature);
				weatherDTO.setStatus(status);
				weatherDTO.setHuminity(huminity);
				weatherDTO = wc.add(weatherDTO);
				action.setPath("/WEB-INF/views/weather/add.jsp");
			}else {
				action.setPath("/WEB-INF/views/weather/add.jsp");				
			}
			
		}else if(uri.equals("/delete")) {
			action.setPath("/WEB-INF/views/weather/delete.jsp");
		}else if(uri.equals("/detail")) {
			//jsp는 동일한데 어느 도시를 클릭하냐에 따라 다른 데이터가 나와야하는데 어떻게 할 것인가?
			//중복되지 않는 데이터, 구분할 수 있는 데이터를 보내야 서로 다른 결과물을 보여줄 수 있다
			//지역명, 기온 같은 데이터는 중복될 가능성이 있으니 도시번호가 가장 확실
			String num = request.getParameter("num");
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setNum(Long.parseLong(num));
			weatherDTO = wc.getDetail(weatherDTO);
			
			if(weatherDTO != null) {
				request.setAttribute("dto", weatherDTO);
				action.setPath("/WEB-INF/views/weather/detail.jsp");
			}else {
				request.setAttribute("message", "정보가 없습니다");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}
		}else {
			
		}
		
		
		return action;
		
	}
	
}
