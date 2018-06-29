package sms.action.student;

import java.util.Scanner;

import sms.action.Action;
import sms.dto.Student;
import sms.service.student.StudentAddService;
import sms.view.ConsoleView;

public class StuAddAction implements Action{
	
	ConsoleView view = new ConsoleView();
	StudentAddService stuAddService = new StudentAddService();

	@Override
	public void excute(Scanner sc) throws Exception {
		//학번을 입력 받기
		int stu_no = view.getStudentNo(sc);
		
		//학번으로 학생 기등록 여부 검사
		Student stu = stuAddService.searchStudent(stu_no);
		if(stu != null){
			view.printRegistedStudent(stu_no);
			return;
		}
		
		//새로운 학생을 view를 통해 입력받음
		Student newStudent = view.addStudent(stu_no,sc);
		
		//학생을 Service를 통해 입력여부 확인
		boolean isRegistStudent = stuAddService.addStudent(newStudent);
		if(isRegistStudent){
			view.printStudentAddSuccess(newStudent);
		}else{
			view.printStudentAddFail(newStudent);
		}
	}
	
	
	
}
