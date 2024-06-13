package com.lsw.home.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lsw.home.Action;

public class StudentController {
	
	private StudentService studentService;
	public StudentController() {
		studentService = new StudentService();
	}
	

	public Action start(HttpServletRequest request) {
		// /student/모시꺵
		//list => 학생정보전체출력
		//add => 학생한명정보추가
		//delete => 학생한명정보삭제
		//detail => 학생한명정보출력
		
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"));
		
		Action action = new Action();
		action.setFlag(true);
		
		String method = request.getMethod();
		
		if(uri.equals("/list")) {
			List<StudentDTO> ar = studentService.getStudents();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/student/list.jsp");
		}else if(uri.equals("/add")) {
			
			if(method.toUpperCase().equals("POST")) {//method값이 대문자인지 소문자인지를 모르니까 걍 대문자로 통일
				System.out.println("학생 등록 데이터를 꺼내야 함");
				StudentDTO student = new StudentDTO();
				String name = request.getParameter("name");
				int num = Integer.parseInt(request.getParameter("num"));
				double avg = Double.parseDouble(request.getParameter("avg"));
				student.setName(name);
				student.setNum(num);
				student.setAvg(avg);
				
				System.out.println(request.getParameter("ch"));
				System.out.println(request.getParameter("mobile"));
				String[] sports = request.getParameterValues("sports");
				
				for(String s: sports) {
					System.out.println(s);
				}
				
				action.setFlag(false);
				action.setPath("./list");
			}else {				
				action.setPath("/WEB-INF/views/student/add.jsp");
			}
			
		}else if(uri.equals("/delete")) {
			action.setPath("/WEB-INF/views/student/delete.jsp");
		}else if(uri.equals("/detail")) {
			String num = request.getParameter("num");
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setNum(Integer.parseInt(num));
			studentDTO = studentService.getDetail(studentDTO);
			
			if(studentDTO != null) {				
				request.setAttribute("std", studentDTO);
				action.setPath("/WEB-INF/views/student/detail.jsp");
			}else {
				request.setAttribute("message", "정보가 없습니다");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}
			
		}else {
			
		}
		
		
		return action;
		
	}
	
}
