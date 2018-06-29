package sms.service.student;

import static sms.db.JdbcUtil.close;
import static sms.db.JdbcUtil.commit;
import static sms.db.JdbcUtil.getConnection;
import static sms.db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import sms.dto.Student;
import sms.model.StudentDAO;

public class StudentDeleteService {
	public boolean deleteStudent(int stu_no) {
		
		boolean isSeccess = false;
		Connection con = getConnection();
		StudentDAO stuDAO = new StudentDAO(con);
		
		int deleteCount = stuDAO.deleteStudent(stu_no);
		
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
