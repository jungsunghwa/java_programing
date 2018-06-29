package sms.service.student;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import sms.dto.Student;
import sms.model.StudentDAO;

import static sms.db.JdbcUtil.*;

public class StudentAddService {
	
	public Student searchStudent(int stu_no){
		
		Connection con = getConnection();
		StudentDAO stuDAO = new StudentDAO(con);
		Student student = stuDAO.selectStudent(stu_no);
		
		return student;
	}
	
	public boolean addStudent(Student newStudent){
		
		boolean isRegistStudent = false;
		Connection con = getConnection();
		StudentDAO stuDAO = new StudentDAO(con);
		Date birth = null;
		
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long time = sdf.parse(newStudent.getStu_birth()).getTime();
			birth = new Date(time);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//»ðÀÔµÈ Çà¼ö¸¦ ¹Þ¾Æ¿È
		int insertCount = stuDAO.addStudent(newStudent, birth);
		if(insertCount > 0){
			isRegistStudent = true;
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		return isRegistStudent;
	}

}
