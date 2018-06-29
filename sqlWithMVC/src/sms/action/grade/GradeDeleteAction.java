package sms.action.grade;

import java.util.Scanner;

import sms.action.Action;
import sms.dto.Grade;
import sms.dto.Student;
import sms.service.grade.GradeDeleteService;
import sms.service.grade.GradeSearchService;
import sms.service.student.StudentAddService;
import sms.view.ConsoleView;

public class GradeDeleteAction implements Action{
	
	ConsoleView view = new ConsoleView();
	GradeSearchService gradeSearchService = new GradeSearchService();
	GradeDeleteService gradeDeleteService = new GradeDeleteService();
	StudentAddService stuAddService = new StudentAddService();
 	
	@Override
	public void excute(Scanner sc) throws Exception {
		int stu_no = view.getStudentNo(sc);
		
		Student stu = stuAddService.searchStudent(stu_no);
		Grade grade = gradeSearchService.searchGrade(stu_no);
		if(stu == null){
			view.printNotFoundStudent();
			return;
		}else if(grade != null){
			boolean isSeccess = gradeDeleteService.deleteGarde(stu_no);
			if(isSeccess){
				view.printGradeDeleteSuccess(grade);
			}else{
				view.printGradeDeleteFail(grade);
			}
		}
	}

}
