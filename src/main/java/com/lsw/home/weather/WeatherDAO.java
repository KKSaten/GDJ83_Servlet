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
				if (s.isEmpty()) {
					
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
	public void add(WeatherDTO weatherDTO) throws Exception{
		
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
	}
	
	
	
	public void delete(WeatherDTO weatherDTO) throws Exception{
		
		// list불러와서
		// 지울려고 하는 num과 일치하는 것을 리스트에서 삭제
		// list를 파일에 다시 저장
		List<WeatherDTO> list = this.getWeathers();
		for (WeatherDTO dto : list) {
			if (dto.getNum() == weatherDTO.getNum()) {
				list.remove(dto);
				break;
			}
			// 안지우고도 continue를 통해서 하기 코드와 동일하게 쓸 수 있음
		}

		// list를 파일에 작성
		File file = new File("C:\\study", "weather.txt");
		FileWriter fw = new FileWriter(file, false); // false는 덮어 씌우는 것
		// 반복문 --> index 번호 필요없다.
		// 하나의 날씨 정보 일렬로

		// 하나 꺼내서 쓰고 하나꺼내서 쓰자
		// 절대 중복될 수 없는 숫자.. --> 시간은 계속 흘러감 중복되는 시간은 없나
		for (WeatherDTO dto : list) {
			StringBuffer stringBuffer = new StringBuffer(); // 반복문 돌떄마다 새로운 객체 생성
			stringBuffer.append(dto.getNum()); // 넘버 첫번쨰로 나오게 하고
			stringBuffer.append("-");
			stringBuffer.append(dto.getCity());
			stringBuffer.append("-");
			stringBuffer.append(dto.getTemperature());
			stringBuffer.append("-");
			stringBuffer.append(dto.getStatus());
			stringBuffer.append("-");
			stringBuffer.append(dto.getHumidity());
			fw.write(stringBuffer.toString() + "\r\n");
			fw.flush();
		}
		
		
		
//		File file = new File("C:\\study", "weather.txt");
//		FileReader fr = new FileReader(file);
//		BufferedReader br = new BufferedReader(fr);
//		
//		System.out.println("delete 작동중");
//		String s = "";
//		FileWriter fw = new FileWriter(file, true);
//		while( s!=null ) {
//			s = br.readLine();
//			s = s.replace("-", ",");
//			s = s.replace(",", "-");
//			System.out.println(s);
//			
//			StringTokenizer st = new StringTokenizer(s, "-");
//			if(st.nextToken().trim().equals(weatherDTO.getNum()+"")) {
//				fw.write("");
//			} else {				
//				fw.write(s+"\n");
//			}
//		}
//		fw.close();
//		br.close();
//		fr.close();
//		
//		return weatherDTO;
	}//delete 끝
	
	
	
	//update
	public void update(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();
		
		//add(Object); 끝에 추가
		//add(index, Object); 삽입
		//set(index, Object); 수정
		
		for(int i=0; i<ar.size(); i++) {
			if(weatherDTO.getNum() == ar.get(i).getNum()) {
				ar.get(i).setCity(weatherDTO.getCity());
				ar.set(i, weatherDTO);
				break;
			}	
		}
		
		File file = new File("c:\\study\\weather.txt");

		FileWriter fw = new FileWriter(file, false);
		StringBuffer stringBuffer = new StringBuffer();
		for (WeatherDTO dto : ar) {
			stringBuffer.append(dto.getNum());
			stringBuffer.append("-");
			stringBuffer.append(dto.getCity());
			stringBuffer.append("-");
			stringBuffer.append(dto.getTemperature());
			stringBuffer.append("-");
			stringBuffer.append(dto.getStatus());
			stringBuffer.append("-");
			stringBuffer.append(dto.getHumidity());
			stringBuffer.append("\r\n");
		}
		fw.write(stringBuffer.toString() + "\r\n");
		fw.flush();
		
		fw.close();
	}
	
	
	
	
}
