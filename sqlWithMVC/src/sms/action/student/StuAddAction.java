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
		//�й��� �Է� �ޱ�
		int stu_no = view.getStudentNo(sc);
		
		//�й����� �л� ���� ���� �˻�
		Student stu = stuAddService.searchStudent(stu_no);
		if(stu != null){
			view.printRegistedStudent(stu_no);
			return;
		}
		
		//���ο� �л��� view�� ���� �Է¹���
		Student newStudent = view.addStudent(stu_no,sc);
		
		//�л��� Service�� ���� �Է¿��� Ȯ��
		boolean isRegistStudent = stuAddService.addStudent(newStudent);
		if(isRegistStudent){
			view.printStudentAddSuccess(newStudent);
		}else{
			view.printStudentAddFail(newStudent);
		}
	}
	
	
	
}
