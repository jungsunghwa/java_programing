package sms.view;

import java.util.ArrayList;
import java.util.Scanner;

import sms.dto.Grade;
import sms.dto.Student;

public class ConsoleView {
	
	public int getStudentNo(Scanner sc){
		System.out.print("\n 학번 : ");
		
		return sc.nextInt();
	}
	
	public void printRegistedStudent(int stu_no){
		System.out.println("> 학번"+stu_no+"학생은 이미 등록됨");
	}
	
	public Student addStudent(int stu_no, Scanner sc){
		sc.useDelimiter(System.getProperty("line.separator"));
		
		System.out.println("학생정보 입력");
		System.out.print("> 이름: ");		String stu_name = sc.next();
		System.out.print("> 학년: ");		int stu_year = sc.nextInt();
		System.out.print("> 주소: ");		String stu_addr = sc.next();
		System.out.print("> 전화번호: ");		String stu_tel = sc.next();
		System.out.print("> 생일: ");		String stu_birth = sc.next();
		
		return new Student(stu_no, stu_name, stu_year, stu_addr
				, stu_tel, stu_birth);
	}

	public void printStudentAddSuccess(Student newStudent) {
		System.out.println(newStudent.getStu_name()+"이(가) 등록되었습니다.");
	}

	public void printStudentAddFail(Student newStudent) {
		System.out.println(newStudent.getStu_name()+"의 입력을 실패 하였습니다.");
	}

	public void printStudentList(ArrayList<Student> students) {
		System.out.println("총 "+students.size()+"명의 학생을 조회합니다.");
		System.out.println("   학번       이름       학년     주소             전화번호     생년월일");
		for(Student stu:students){
			System.out.println(stu.toString());
		}
	}
	
	public void pirntStudentListFail() {
		System.out.println("학생 목록 조회에 실패했습니다.");
	}

	public void printStudentModifySuccess(Student student) {
		System.out.println(student.getStu_name()+"을(를) 수정하였습니다.");
	}
	
	public void printStudentModifyFail(Student student) {
		System.out.println(student+"의 정보 수정에 실패 하였습니다.");
	}

	public void printStudentDeleteSuccess(String stu_name) {
		System.out.println(stu_name+"을(를) 삭제 하였습니다.");
		
	}
	
	public void printStudentDeleteFail(Student student) {
		System.out.println(student.getStu_name()+"을(를) 삭제에 시패 하였습니다.");
	}

	public void printNotFoundStudent() {
		System.out.println("없는 학번입니다.");
	}
	
	
	//====================================================================================================================//

	public void printGradeAddSuccess(Grade grade) {
		System.out.println(grade.getStu_name()+"에 성적을 삽입했습니다.");
	}
	
	public void printRegistedGrade() {
		System.out.println("이미 기입된 성적입니다.");
	}

	public Grade addGrade(Student stu,Scanner sc) {
		sc.useDelimiter(System.getProperty("line.separator"));
		
		System.out.println("성적정보 입력");
		System.out.print("> 국어: ");		int korean = sc.nextInt();
		System.out.print("> 영어: ");		int english = sc.nextInt();
		System.out.print("> 수학: ");		int math = sc.nextInt();
		
		return new Grade(stu.getStu_no(), stu.getStu_name(), korean, english, math);
	}
	
	public void printGradeAddFail(Grade grade) {
		System.out.println(grade.getStu_name()+"의 성적을 수정하였습니다.");
	}

	public void printGradeList(ArrayList<Grade> grades) {
		System.out.println("총 "+grades.size()+"개의 성적을 조회합니다.");
		for(Grade grade:grades){
			System.out.println(grade.toString());
		}
	}
	
	public void printGradeListFail() {
		System.out.println("성적 목록 조회에 실패했습니다.");
	}

	public void printGradeModifySuccess(Grade grade) {
		System.out.println(grade.getStu_name()+"의 성적을 수정하였습니다.");
	}
	
	public void printGradeModifyFail(Grade grade) {
		System.out.println(grade.getStu_name()+"의 성적을 수정하였습니다.");
	}

	public void printGradeDeleteSuccess(Grade grade) {
		System.out.println(grade.getStu_name()+"의 성적을 삭제 했습니다.");
	}
	
	public void printGradeDeleteFail(Grade grade) {
		System.out.println(grade.getStu_name()+"의 성적을 삭제 했습니다.");
	}
	
}
