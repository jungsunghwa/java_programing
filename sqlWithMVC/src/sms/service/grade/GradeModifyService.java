package sms.service.grade;

import static sms.db.JdbcUtil.close;
import static sms.db.JdbcUtil.commit;
import static sms.db.JdbcUtil.getConnection;
import static sms.db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import sms.dto.Grade;
import sms.dto.Student;
import sms.model.GradeDAO;
import sms.model.StudentDAO;

public class GradeModifyService {

	public boolean modifyGrade(Grade grade) {
		
		boolean isSeccess = false;
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
	
		int insertCount = gradeDAO.modifyGrade(grade);
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
