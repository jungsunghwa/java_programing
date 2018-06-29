package sms.action.grade;

import java.util.ArrayList;
import java.util.Scanner;

import sms.action.Action;
import sms.dto.Grade;
import sms.dto.Student;
import sms.service.grade.GradeListService;
import sms.service.student.StudentListService;
import sms.view.ConsoleView;

public class GradeListAction implements Action{

	ConsoleView view = new ConsoleView();
	GradeListService gradeListService = new GradeListService(); 
	
	@Override
	public void excute(Scanner sc) throws Exception {
		ArrayList<Grade> grades = gradeListService.getAllGrade();
		if(grades != null){
			view.printGradeList(grades);
		}else{
			view.printGradeListFail();
		}
	}

}
