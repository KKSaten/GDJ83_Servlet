package com.lsw.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherDAO {
	
	//DTO : Data Transfer Object : 데이터를 담는 역할만 했음
	//DAO : Data Access Object : 데이터에 접근도 함
	
	//getWeathers
	//파일에 날씨정보들을 읽어와서 파싱한 후, DTO에 담아서 return
	
	
	//파일에서 list를 꺼내오는 메서드
	public List<WeatherDTO> getWeathers() {
		
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
					weatherDTO.setHumidity(Integer.parseInt(st.nextToken().trim()));
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
		
		
		
	}//read()끝
	
	
	public WeatherDTO getDetail(WeatherDTO weatherDTO) throws Exception{
		//나중엔 file이 아니라 db에서 꺼내오는 것이라 코드가 간단해지지만
		//이를 배우기 위해 흉내내는 과정에 있다보니 코드가 좀 복잡해짐
		List<WeatherDTO> ar = this.getWeathers();
		
		WeatherDTO result = null;
		
		for(WeatherDTO w : ar) {
			if(w.getNum() == weatherDTO.getNum()) {
				result = w;
				break;
			}
		}
		
		return result;
		
	}//getDetail() 끝
	
	
	//add메서드
	public WeatherDTO add(WeatherDTO weatherDTO) throws Exception{
		
		List<WeatherDTO> ar = this.getWeathers();
		
		//도시명-기온-상태-습도		
		StringBuffer sb = new StringBuffer();
		Calendar ca = Calendar.getInstance();
		sb.append(ca.getTimeInMillis());//num대신 절대 중복될 수 없는 밀리초 단위의 시간으로. 
		sb.append("-");
		sb.append(weatherDTO.getCity());
		sb.append("-");
		sb.append(weatherDTO.getTemperature());
		sb.append("-");
		sb.append(weatherDTO.getStatus());
		sb.append("-");
		sb.append(weatherDTO.getHumidity());
		
		File file = new File("C:\\study", "weather.txt");
		FileWriter fw = new FileWriter(file, true);
		fw.write(sb+"\r\n");
		fw.flush();
		
		fw.close();
		
		
		return weatherDTO;
	}
	
	
	
	public WeatherDTO delete(WeatherDTO weatherDTO) throws Exception{
		
		File file = new File("C:\\study", "weather.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		System.out.println("delete 작동중");
		String s = "";
		FileWriter fw = new FileWriter(file, true);
		while( s!=null ) {
			s = br.readLine();
			s = s.replace("-", ",");
			s = s.replace(",", "-");
			System.out.println(s);
			
			StringTokenizer st = new StringTokenizer(s, "-");
			if(st.nextToken().trim().equals(weatherDTO.getNum()+"")) {
				fw.write("");
			} else {				
				fw.write(s+"\n");
			}
		}
		fw.close();
		br.close();
		fr.close();
		
		return weatherDTO;
	}//delete 끝
	
	
	
	
	
}
