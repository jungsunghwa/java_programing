package sms.service.student;

import static sms.db.JdbcUtil.getConnection;

import sms.dto.Student;
import sms.model.StudentDAO;

import java.sql.Connection;
import java.util.ArrayList;

public class StudentSearchService {

    public ArrayList<Student> searchByStudentNumber(int stu_no) {
        Connection con = getConnection();
        StudentDAO studentDAO = new StudentDAO(con);

        ArrayList<Student> students = studentDAO.searchByStudentNumber(stu_no);

        return students;
    }

    public ArrayList<Student> searchByStudentName(String stu_name) {
        Connection con = getConnection();
        StudentDAO studentDAO = new StudentDAO(con);

        ArrayList<Student> students = studentDAO.searchByStudentName(stu_name);

        return students;
    }

    public ArrayList<Student> searchByStudentGrade(int stu_tear) {
        Connection con = getConnection();
        StudentDAO studentDAO = new StudentDAO(con);

        ArrayList<Student> students = studentDAO.searchByStudentGrade(stu_tear);

        return students;
    }
}
