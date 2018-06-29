package sms.action.grade;

import java.util.Scanner;

import sms.action.Action;
import sms.dto.Grade;
import sms.dto.Student;
import sms.service.grade.GradeAddService;
import sms.service.grade.GradeSearchService;
import sms.service.student.StudentAddService;
import sms.view.ConsoleView;

public class GradeAddAction implements Action{

	ConsoleView view = new ConsoleView();
	Grade grade = null;
	StudentAddService stuAddService = new StudentAddService();
	GradeAddService gradeAddService = new GradeAddService();
	GradeSearchService gradeSearchService = new GradeSearchService();
	
	@Override
	public void excute(Scanner sc) throws Exception {
		int stu_no = view.getStudentNo(sc);
	
		Student stu = stuAddService.searchStudent(stu_no);
		grade = gradeSearchService.searchGrade(stu_no);
		
		if(stu == null){
			view.printNotFoundStudent();
			return;
		}else if (grade != null) {
			view.printRegistedGrade();
			return;
		}
		
		grade = view.addGrade(stu, sc);
		
		boolean isSeccess = gradeAddService.addGrade(grade);
		if(isSeccess){
			view.printGradeAddSuccess(grade);
		}else{
			view.printGradeAddFail(grade);
		}
		
	}

}
