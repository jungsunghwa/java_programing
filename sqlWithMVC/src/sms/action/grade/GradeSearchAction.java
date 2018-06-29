package sms.action.grade;

import java.util.ArrayList;
import java.util.Scanner;

import sms.action.Action;
import sms.dto.Grade;
import sms.dto.Student;
import sms.service.grade.GradeSearchService;
import sms.service.student.StudentAddService;
import sms.view.ConsoleView;

public class GradeSearchAction implements Action{

	ConsoleView view = new ConsoleView();
	StudentAddService stuAddService = new StudentAddService();
	GradeSearchService gradeSearchService = new GradeSearchService();
	
	@Override
	public void excute(Scanner sc) throws Exception {
		
		int stu_no = view.getStudentNo(sc);
		
		ArrayList<Grade> grades = new ArrayList<Grade>();
		Student student = stuAddService.searchStudent(stu_no);
		
		if(student == null){
			view.printNotFoundStudent();
			return;
		}else{
			grades.add(gradeSearchService.searchGrade(stu_no));
			view.printGradeList(grades);
		}
	}

}
