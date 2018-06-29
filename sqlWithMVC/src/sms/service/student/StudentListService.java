package sms.service.student;

import static sms.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import sms.dto.Student;
import sms.model.StudentDAO;

public class StudentListService {

	public ArrayList<Student> getAllStudent() {
		Connection con = getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		ArrayList<Student> students = studentDAO.selectAllStudent();
	
		
		return students;
	}
	
}
