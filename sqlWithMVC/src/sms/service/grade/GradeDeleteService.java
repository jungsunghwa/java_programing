package sms.service.grade;

import static sms.db.JdbcUtil.close;
import static sms.db.JdbcUtil.commit;
import static sms.db.JdbcUtil.getConnection;
import static sms.db.JdbcUtil.rollback;

import java.sql.Connection;

import sms.dto.Grade;
import sms.model.GradeDAO;
import sms.model.StudentDAO;

public class GradeDeleteService {

	public boolean deleteGarde(int stu_no) {
		boolean isSeccess = false;
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		
		int deleteCount = gradeDAO.deleteGrade(stu_no);
		
		if(deleteCount > 0){
			isSeccess = true;
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return isSeccess;
	}

}
