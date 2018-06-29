package sms.service.grade;

import java.sql.Connection;

import static sms.db.JdbcUtil.*;

import sms.dto.Grade;
import sms.model.GradeDAO;

public class GradeSearchService {

	public Grade searchGrade(int stu_no) {
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		Grade grade = gradeDAO.selectGrade(stu_no);
		
		return grade;
	}

}
