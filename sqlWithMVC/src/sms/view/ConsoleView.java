package sms.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import sms.dto.Grade;
import sms.dto.Student;

public class ConsoleView {

	public int getStudentNo(Scanner sc){
		System.out.print("\n ?? : ");

		return sc.nextInt();
	}

	public HashMap<String,String> getTypeOfSearchStudent(Scanner sc) {
		HashMap<String, String> hashMap = new HashMap<>();
		int type;
		String content;

		System.out.println("?? ??? ??????");

		System.out.println("1. ??");
		System.out.println("2. ??");
		System.out.println("3. ??");

		System.out.print("?? >");  type = sc.nextInt();

		hashMap.put("type",type+"");

		System.out.println("??? ??? ?????");
		System.out.print("?? > "); content = sc.next();

		hashMap.put("content", content);

		return hashMap;

	}

	public void printRegistedStudent(int stu_no){
		System.out.println("> ??"+stu_no+"??? ?? ???");
	}

	public Student addStudent(int stu_no, Scanner sc){
		sc.useDelimiter(System.getProperty("line.separator"));

		System.out.println("???? ??");
		System.out.print("> ??: ");		String stu_name = sc.next();
		System.out.print("> ??: ");		int stu_year = sc.nextInt();
		System.out.print("> ??: ");		String stu_addr = sc.next();
		System.out.print("> ????: ");		String stu_tel = sc.next();
		System.out.print("> ??: ");		String stu_birth = sc.next();

		return new Student(stu_no, stu_name, stu_year, stu_addr
				, stu_tel, stu_birth);
	}

	public void printStudentAddSuccess(Student newStudent) {
		System.out.println(newStudent.getStu_name()+"?(?) ???????.");
	}

	public void printStudentAddFail(Student newStudent) {
		System.out.println(newStudent.getStu_name()+"? ??? ?? ?????.");
	}

	public void printStudentList(ArrayList<Student> students) {
		System.out.println("? "+students.size()+"?? ??? ?????.");
		System.out.println("   ??       ??       ??     ??             ????     ????");
		for(Student stu:students){
			System.out.println(stu.toString());
		}
	}

	public void pirntStudentListFail() {
		System.out.println("?? ?? ??? ??????.");
	}

	public void printStudentModifySuccess(Student student) {
		System.out.println(student.getStu_name()+"?(?) ???????.");
	}

	public void printStudentModifyFail(Student student) {
		System.out.println(student+"? ?? ??? ?? ?????.");
	}

	public void printStudentDeleteSuccess(String stu_name) {
		System.out.println(stu_name+"?(?) ?? ?????.");

	}

	public void printStudentDeleteFail(Student student) {
		System.out.println(student.getStu_name()+"?(?) ??? ?? ?????.");
	}

	public void printNotFoundStudent() {
		System.out.println("?? ?????.");
	}


	//====================================================================================================================//

	public void printGradeAddSuccess(Grade grade) {
		System.out.println(grade.getStu_name()+"? ??? ??????.");
	}

	public void printRegistedGrade() {
		System.out.println("?? ??? ?????.");
	}

	public Grade addGrade(Student stu,Scanner sc) {
		sc.useDelimiter(System.getProperty("line.separator"));

		System.out.println("???? ??");
		System.out.print("> ??: ");		int korean = sc.nextInt();
		System.out.print("> ??: ");		int english = sc.nextInt();
		System.out.print("> ??: ");		int math = sc.nextInt();

		return new Grade(stu.getStu_no(), stu.getStu_name(), korean, english, math);
	}

	public void printGradeAddFail(Grade grade) {
		System.out.println(grade.getStu_name()+"? ??? ???????.");
	}

	public void printGradeList(ArrayList<Grade> grades) {
		System.out.println("? "+grades.size()+"?? ??? ?????.");
		for(Grade grade:grades){
			System.out.println(grade.toString());
		}
	}

	public void printGradeListFail() {
		System.out.println("?? ?? ??? ??????.");
	}

	public void printGradeModifySuccess(Grade grade) {
		System.out.println(grade.getStu_name()+"? ??? ???????.");
	}

	public void printGradeModifyFail(Grade grade) {
		System.out.println(grade.getStu_name()+"? ??? ???????.");
	}

	public void printGradeDeleteSuccess(Grade grade) {
		System.out.println(grade.getStu_name()+"? ??? ?? ????.");
	}

	public void printGradeDeleteFail(Grade grade) {
		System.out.println(grade.getStu_name()+"? ??? ?? ????.");
	}
}