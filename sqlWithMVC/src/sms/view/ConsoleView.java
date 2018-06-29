package sms.view;

import java.util.ArrayList;
import java.util.Scanner;

import sms.dto.Grade;
import sms.dto.Student;

public class ConsoleView {
	
	public int getStudentNo(Scanner sc){
		System.out.print("\n �й� : ");
		
		return sc.nextInt();
	}
	
	public void printRegistedStudent(int stu_no){
		System.out.println("> �й�"+stu_no+"�л��� �̹� ��ϵ�");
	}
	
	public Student addStudent(int stu_no, Scanner sc){
		sc.useDelimiter(System.getProperty("line.separator"));
		
		System.out.println("�л����� �Է�");
		System.out.print("> �̸�: ");		String stu_name = sc.next();
		System.out.print("> �г�: ");		int stu_year = sc.nextInt();
		System.out.print("> �ּ�: ");		String stu_addr = sc.next();
		System.out.print("> ��ȭ��ȣ: ");		String stu_tel = sc.next();
		System.out.print("> ����: ");		String stu_birth = sc.next();
		
		return new Student(stu_no, stu_name, stu_year, stu_addr
				, stu_tel, stu_birth);
	}

	public void printStudentAddSuccess(Student newStudent) {
		System.out.println(newStudent.getStu_name()+"��(��) ��ϵǾ����ϴ�.");
	}

	public void printStudentAddFail(Student newStudent) {
		System.out.println(newStudent.getStu_name()+"�� �Է��� ���� �Ͽ����ϴ�.");
	}

	public void printStudentList(ArrayList<Student> students) {
		System.out.println("�� "+students.size()+"���� �л��� ��ȸ�մϴ�.");
		System.out.println("   �й�       �̸�       �г�     �ּ�             ��ȭ��ȣ     �������");
		for(Student stu:students){
			System.out.println(stu.toString());
		}
	}
	
	public void pirntStudentListFail() {
		System.out.println("�л� ��� ��ȸ�� �����߽��ϴ�.");
	}

	public void printStudentModifySuccess(Student student) {
		System.out.println(student.getStu_name()+"��(��) �����Ͽ����ϴ�.");
	}
	
	public void printStudentModifyFail(Student student) {
		System.out.println(student+"�� ���� ������ ���� �Ͽ����ϴ�.");
	}

	public void printStudentDeleteSuccess(String stu_name) {
		System.out.println(stu_name+"��(��) ���� �Ͽ����ϴ�.");
		
	}
	
	public void printStudentDeleteFail(Student student) {
		System.out.println(student.getStu_name()+"��(��) ������ ���� �Ͽ����ϴ�.");
	}

	public void printNotFoundStudent() {
		System.out.println("���� �й��Դϴ�.");
	}
	
	
	//====================================================================================================================//

	public void printGradeAddSuccess(Grade grade) {
		System.out.println(grade.getStu_name()+"�� ������ �����߽��ϴ�.");
	}
	
	public void printRegistedGrade() {
		System.out.println("�̹� ���Ե� �����Դϴ�.");
	}

	public Grade addGrade(Student stu,Scanner sc) {
		sc.useDelimiter(System.getProperty("line.separator"));
		
		System.out.println("�������� �Է�");
		System.out.print("> ����: ");		int korean = sc.nextInt();
		System.out.print("> ����: ");		int english = sc.nextInt();
		System.out.print("> ����: ");		int math = sc.nextInt();
		
		return new Grade(stu.getStu_no(), stu.getStu_name(), korean, english, math);
	}
	
	public void printGradeAddFail(Grade grade) {
		System.out.println(grade.getStu_name()+"�� ������ �����Ͽ����ϴ�.");
	}

	public void printGradeList(ArrayList<Grade> grades) {
		System.out.println("�� "+grades.size()+"���� ������ ��ȸ�մϴ�.");
		for(Grade grade:grades){
			System.out.println(grade.toString());
		}
	}
	
	public void printGradeListFail() {
		System.out.println("���� ��� ��ȸ�� �����߽��ϴ�.");
	}

	public void printGradeModifySuccess(Grade grade) {
		System.out.println(grade.getStu_name()+"�� ������ �����Ͽ����ϴ�.");
	}
	
	public void printGradeModifyFail(Grade grade) {
		System.out.println(grade.getStu_name()+"�� ������ �����Ͽ����ϴ�.");
	}

	public void printGradeDeleteSuccess(Grade grade) {
		System.out.println(grade.getStu_name()+"�� ������ ���� �߽��ϴ�.");
	}
	
	public void printGradeDeleteFail(Grade grade) {
		System.out.println(grade.getStu_name()+"�� ������ ���� �߽��ϴ�.");
	}
	
}
