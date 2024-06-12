package com.lsw.home.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentService {
	
	public List<Student> getStudents() {
		ArrayList<Student> ar = new ArrayList<Student>();
		Random random = new Random();
		
		for(int i=1; i<=5; i++) {
			Student student = new Student();
			
			student.setNum(i);
			student.setName("name" + i);
			student.setAvg(random.nextInt(100) + random.nextDouble());
			
			ar.add(student);
		}
		
		return ar;
		
	}
	
	public Student makeStudent() {
		Student student = new Student();
		//DB에서 꺼내올 데이터
		student.setNum(1);
		student.setName("LeeSiwoo");
		student.setAvg(58.58);
		
		return student;
	}

}
