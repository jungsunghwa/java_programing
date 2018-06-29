package sms.service.grade;

import static sms.db.JdbcUtil.close;
import static sms.db.JdbcUtil.commit;
import static sms.db.JdbcUtil.getConnection;
import static sms.db.JdbcUtil.rollback;

import java.sql.Connection;

import sms.action.grade.GradeDeleteAction;
import sms.dto.Grade;
import sms.model.GradeDAO;

public class GradeAddService {

	public boolean addGrade(Grade grade) {
		boolean isSeccess = false;
		
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		
		int insertCount = gradeDAO.addGrade(grade);
		if(insertCount > 0){
			isSeccess = true;
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return isSeccess;
	}
	
}
