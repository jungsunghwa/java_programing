package sms.service.grade;

import static sms.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import sms.dto.Grade;
import sms.dto.Student;
import sms.model.GradeDAO;
import sms.model.StudentDAO;

public class GradeListService {

	public ArrayList<Grade> getAllGrade() {
		
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		ArrayList<Grade> grades = gradeDAO.selectAllStudent();
		
		return grades;
	}

}
