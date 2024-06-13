package com.lsw.home.student;

import java.util.List;

public class StudentService {
	
	private StudentDAO studentDAO;
	public StudentService() {
		studentDAO = new StudentDAO();	
	}
	
	//list 가져오기
	public List<StudentDTO> getStudents() {
		List<StudentDTO> ar = null;
		try {
			ar = studentDAO.getStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ar;
	}
	
	//detail 가져오기
	public StudentDTO getDetail(StudentDTO studentDTO) {
		try {
			studentDTO = studentDAO.getDetail(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			studentDTO = null;
		}
		
		return studentDTO;
	}

}
