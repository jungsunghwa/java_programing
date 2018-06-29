package sms.action.grade;

import java.util.Scanner;

import sms.action.Action;
import sms.dto.Grade;
import sms.dto.Student;
import sms.service.grade.GradeModifyService;
import sms.service.grade.GradeSearchService;
import sms.service.student.StudentAddService;
import sms.service.student.StudentModifyService;
import sms.view.ConsoleView;

public class GradeModifyAction implements Action{

	ConsoleView view = new ConsoleView();
	StudentAddService stuAddService = new StudentAddService();
	GradeSearchService gradeSearchService = new GradeSearchService();
	GradeModifyService gradeModifyService = new GradeModifyService();
	
	@Override
	public void excute(Scanner sc) throws Exception {
		int stu_no = view.getStudentNo(sc);
		
		Student stu = stuAddService.searchStudent(stu_no);
		Grade grade = gradeSearchService.searchGrade(stu_no);
		
		if(stu == null){
			view.printNotFoundStudent();
			return;
		}else if (grade != null) {
			grade = view.addGrade(stu, sc);
			
			boolean isRegistStudent = gradeModifyService.modifyGrade(grade);
			if(isRegistStudent){
				view.printGradeModifySuccess(grade);
			}else{
				view.printGradeModifyFail(grade);
			}
		}
	}

}
