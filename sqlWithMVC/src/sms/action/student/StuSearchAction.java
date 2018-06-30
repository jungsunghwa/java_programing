package sms.action.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import sms.action.Action;
import sms.dto.Student;
import sms.service.student.StudentAddService;
import sms.service.student.StudentSearchService;
import sms.view.ConsoleView;

public class StuSearchAction implements Action{

	ConsoleView view = new ConsoleView();
	StudentSearchService studentSearchService = new StudentSearchService();
	
	@Override
	public void excute(Scanner sc) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, String> searchStudent = view.getTypeOfSearchStudent(sc);

		ArrayList<Student> students = new ArrayList<Student>();

		int type = Integer.parseInt(searchStudent.get("type"));
		String content = searchStudent.get("content");

		switch (type){
			case 1:
				students = studentSearchService.searchByStudentNumber(new Integer(content));
				break;
			case 2:
				students = (studentSearchService.searchByStudentName(content));
				break;
			case 3:
				students = studentSearchService.searchByStudentGrade(new Integer(content));
				break;

		}

		
		if(students == null){
			view.printNotFoundStudent();
			return;
		}else {
			view.printStudentList(students);
		}

	}

}