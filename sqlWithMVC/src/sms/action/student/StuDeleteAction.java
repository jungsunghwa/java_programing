package sms.action.student;

import java.util.ArrayList;
import java.util.Scanner;

import sms.action.Action;
import sms.dto.Student;
import sms.service.student.StudentAddService;
import sms.service.student.StudentDeleteService;
import sms.view.ConsoleView;

public class StuDeleteAction implements Action{

	ConsoleView view = new ConsoleView();
	StudentAddService stuAddService = new StudentAddService();
	StudentDeleteService studentDeleteService = new StudentDeleteService();
	@Override
	public void excute(Scanner sc) throws Exception {
		int stu_no = view.getStudentNo(sc);
		
		Student student = stuAddService.searchStudent(stu_no);
		if(student == null){
			view.printNotFoundStudent();
			return;
		}else{
			boolean isDelete = studentDeleteService.deleteStudent(stu_no);
			if(isDelete){
				view.printStudentDeleteSuccess(student.getStu_name());
			}else{
				view.printStudentDeleteFail(student);
			}
		}
	}

}
