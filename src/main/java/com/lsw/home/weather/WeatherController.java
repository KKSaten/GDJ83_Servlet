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
		
		
		if(uri.equals("/list")) {
			List<WeatherDTO> ar = wc.getWeathers();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/weather/list.jsp");
		}else if(uri.equals("/add")) {
			action.setPath("/WEB-INF/views/weather/add.jsp");
		}else if(uri.equals("/delete")) {
			action.setPath("/WEB-INF/views/weather/delete.jsp");
		}else if(uri.equals("/detail")) {
			action.setPath("/WEB-INF/views/weather/detail.jsp");
		}else {
			
		}
		
		
		return action;
		
	}
	
}
