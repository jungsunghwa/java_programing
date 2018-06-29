package sms.action.student;

import java.util.ArrayList;
import java.util.Scanner;

import sms.action.Action;
import sms.dto.Student;
import sms.service.student.StudentAddService;
import sms.service.student.StudentModifyService;
import sms.view.ConsoleView;

public class StuModifyAction implements Action{

	ConsoleView view = new ConsoleView();
	StudentAddService stuAddService = new StudentAddService();
	StudentModifyService stuModifyService = new StudentModifyService();
	
	@Override
	public void excute(Scanner sc) throws Exception {
		
		int stu_no = view.getStudentNo(sc);
		
		Student student = stuAddService.searchStudent(stu_no);
		
		if(student == null){
			view.printNotFoundStudent();
			return;
		}else{
			student = view.addStudent(stu_no, sc);
			
			boolean isRegistStudent = stuModifyService.modifyStudent(student);
			if(isRegistStudent){
				view.printStudentModifySuccess(student);
			}else{
				view.printStudentModifyFail(student);
			}
		}
	}

}
