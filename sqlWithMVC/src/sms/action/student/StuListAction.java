package sms.action.student;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.View;

import sms.action.Action;
import sms.dto.Student;
import sms.service.student.StudentListService;
import sms.view.ConsoleView;

public class StuListAction implements Action{

	ConsoleView view = new ConsoleView();
	StudentListService studentListService = new StudentListService(); 
	
	@Override
	public void excute(Scanner sc) throws Exception {
		ArrayList<Student> students = studentListService.getAllStudent();
		if(students != null){
			view.printStudentList(students);
		}else{
			view.pirntStudentListFail();
		}
	}

}
