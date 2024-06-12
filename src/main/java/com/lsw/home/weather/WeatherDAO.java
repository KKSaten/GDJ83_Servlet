package com.lsw.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherDAO {
	
	//DTO : Data Transfer Object : 데이터를 담는 역할만 했음
	//DAO : Data Access Object : 데이터에 접근도 함
	
	//getWeathers
	//파일에 날씨정보들을 읽어와서 파싱한 후, DTO에 담아서 return
	
	public List<WeatherDTO> read() {
		
		File file = new File("C:\\study", "weather.txt");
		FileReader fr;
		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();
		
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				String s = br.readLine();
				
				if (s == null) {
					break;
				}
				s = s.replace(",", "-");
				StringTokenizer st = new StringTokenizer(s, "-");
				while(st.hasMoreTokens()) {
					WeatherDTO weatherDTO = new WeatherDTO();
					weatherDTO.setNum(Long.parseLong(st.nextToken().trim()));
					weatherDTO.setCity(st.nextToken().trim());
					weatherDTO.setTemperature(Double.parseDouble(st.nextToken().trim()));
					weatherDTO.setStatus(st.nextToken().trim());
					weatherDTO.setHuminity(Integer.parseInt(st.nextToken().trim()));
					ar.add(weatherDTO);
				}//while문 끝
				
			}//while문 끝
			
			br.close();
			fr.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ar;
		
		
		
	}
	
}
