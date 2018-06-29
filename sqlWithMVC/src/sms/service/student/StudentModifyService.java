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

public class StudentModifyService {
	public boolean modifyStudent(Student student) {
			
			boolean isSeccess = false;
			Connection con = getConnection();
			StudentDAO stuDAO = new StudentDAO(con);
			
			Date birth = null;
			
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				long time = sdf.parse(student.getStu_birth()).getTime();
				birth = new Date(time);
			}catch(Exception e){
				e.printStackTrace();
			}
		
		int insertCount = stuDAO.modifyStudent(student, birth);
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
