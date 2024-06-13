package com.lsw.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	public List<StudentDTO> getStudents() throws Exception{
		
		File file = new File("C:\\study\\student.txt");
		ArrayList<StudentDTO> ar = new ArrayList<StudentDTO>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			String s = br.readLine();
			
			if(s == null) {
				break;
			}
			
			StudentDTO studentDTO = new StudentDTO();
			String[] sp = s.split(",");
			studentDTO.setNum(Integer.parseInt(sp[0].trim()));
			studentDTO.setName(sp[1].trim());
			studentDTO.setKor(Integer.parseInt(sp[2].trim()));
			studentDTO.setEng(Integer.parseInt(sp[3].trim()));
			studentDTO.setMath(Integer.parseInt(sp[4].trim()));
			studentDTO.setTotal(Integer.parseInt(sp[5].trim()));
			studentDTO.setAvg(Double.parseDouble(sp[6].trim()));
			ar.add(studentDTO);	
		}//while문 끝
		
		br.close();
		fr.close();
		
		return ar;	
	} //getStudent() 끝
	
	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception {
		List<StudentDTO> ar = this.getStudents();
		
		StudentDTO result = null;
		
		for(StudentDTO s : ar) {
			if(s.getNum() == studentDTO.getNum()) {
				result = s;
				break;
			}	
		}
		
		
		return result;
	}

}
