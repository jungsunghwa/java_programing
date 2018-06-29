package sms.app;

import sms.action.*;
import sms.action.grade.GradeAddAction;
import sms.action.grade.GradeDeleteAction;
import sms.action.grade.GradeListAction;
import sms.action.grade.GradeModifyAction;
import sms.action.grade.GradeSearchAction;
import sms.action.student.StuAddAction;
import sms.action.student.StuDeleteAction;
import sms.action.student.StuListAction;
import sms.action.student.StuModifyAction;
import sms.action.student.StuSearchAction;
import sms.controller.StudentController;
import sms.service.student.StudentListService;

import java.io.IOException;
import java.util.Scanner;

public class AppUI {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        boolean mainMenu = true;
        boolean studentMenu = false;
        boolean gradeMenu = false;

        Action action = null;
        StudentController stuController = new StudentController();

        while (true) {
            if (mainMenu) {
                System.out.println("---------------<학생정보 관리 시스템>---------------");
                System.out.println("                1. 학생 정보 관리");
                System.out.println("                2. 성적 정보 관리");
                System.out.println("                3. 프로그램 종료");
                System.out.print("             선택>" );
                String cmd = sc.next();
                if (cmd.equals("1")) {
                    mainMenu = false;
                    studentMenu = true;
                    gradeMenu = false;
                }
                else if (cmd.equals("2")) {
                    mainMenu = false;
                    studentMenu = false;
                    gradeMenu = true;
                }
                else if (cmd.equals("3")) {
                    System.out.println("시스템을 종료합니다.");
                    System.exit(0);
                    return;
                }else{
                	System.out.println("잘 못 누르셨습니다. 다시 입력 하여 주세요. \n\n\n");
                }
            }
            else if (studentMenu) {
                action = null;
            	System.out.println("--------------------<학생 관리>--------------------");
                System.out.println("                1. 학생 정보 입력");
                System.out.println("                2. 학생 정보 조회");
                System.out.println("                3. 학생 정보 검색");
                System.out.println("                4. 학생 정보 변경");
                System.out.println("                5. 학생 정보 삭제");
                System.out.println("                6. 첫 화면으로");
                System.out.print("             선택>" );
                String cmd = sc.next();
                if (cmd.equals("1")) {
                	action = new StuAddAction();
                }
                else if (cmd.equals("2")) {
                	action = new StuListAction();
                }
                else if (cmd.equals("3")) {
                	action = new StuSearchAction();
                }
                else if (cmd.equals("4")) {
                	action = new StuModifyAction();
                }
                else if (cmd.equals("5")) {
                	action = new StuDeleteAction();
                }
                else if (cmd.equals("6")) {
                    mainMenu = true;
                    studentMenu = false;
                    gradeMenu = false;
                }else{
                	System.out.println("잘 못 누르셨습니다. 다시 입력 하여 주세요.");
                }
            }
            else if (gradeMenu) {
            	action = null;
                System.out.println("--------------------<성적 관리>--------------------");
                System.out.println("                1. 성적 정보 입력");
                System.out.println("                2. 성적 정보 조회");
                System.out.println("                3. 성적 정보 검색");
                System.out.println("                4. 성적 정보 변경");
                System.out.println("                5. 성적 정보 삭제");
                System.out.println("                6. 첫 화면으로");
                System.out.print("             선택>" );
                String cmd = sc.next();
                if (cmd.equals("1")) {
                	action = new GradeAddAction();
                }
                else if (cmd.equals("2")) {
                	action = new GradeListAction();
                }
                else if (cmd.equals("3")) {
                	action = new GradeSearchAction();
                }
                else if (cmd.equals("4")) {
                	action = new GradeModifyAction();
                }
                else if (cmd.equals("5")) {
                	action = new GradeDeleteAction();
                }
                else if (cmd.equals("6")) {
                    mainMenu = true;
                    studentMenu = false;
                    gradeMenu = false;
                }else{
                	System.out.println("잘 못 누르셨습니다. 다시 입력 하여 주세요.");
                }
                
            }
            if(action!=null){ stuController.requestProcess(action, sc); }
        }
    }
}
