package sms.action.student;

import java.util.ArrayList;
import java.util.Scanner;

import sms.action.Action;
import sms.dto.Student;
import sms.service.student.StudentAddService;
import sms.view.ConsoleView;

public class StuSearchAction implements Action{

	ConsoleView view = new ConsoleView();
	StudentAddService stuAddService = new StudentAddService();
	
	@Override
	public void excute(Scanner sc) throws Exception {
		// TODO Auto-generated method stub
		int stu_no = view.getStudentNo(sc);
		
		ArrayList<Student> students = new ArrayList<Student>();
		Student student = stuAddService.searchStudent(stu_no);
		
		if(student == null){
			view.printNotFoundStudent();
			return;
		}else{
			students.add(student);
			view.printStudentList(students);
		}
		
		
	}

}