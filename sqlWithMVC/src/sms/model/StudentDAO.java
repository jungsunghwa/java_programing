package sms.model;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static sms.db.JdbcUtil.*;

import sms.dto.Student;

public class StudentDAO {
	
	Connection con;
	
	public StudentDAO(Connection con){
		this.con = con;
	}
	
	public Student selectStudent(int stu_no){
		Student student = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student WHERE stu_no=?";
		
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stu_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				student = new Student(rs.getInt("stu_no"),
						rs.getString("stu_name"),
						rs.getInt("stu_year"),
						rs.getString("stu_addr"),
						rs.getString("stu_tel"),
						rs.getDate("stu_birth").toString());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		
		return student;
	}
	
	public int addStudent(Student newStudent, Date birth){
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into student values (?,?,?,?,?,?);";
		
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newStudent.getStu_no());
			pstmt.setString(2, newStudent.getStu_name());
			pstmt.setInt(3, newStudent.getStu_year());
			pstmt.setString(4, newStudent.getStu_addr());
			pstmt.setString(5, newStudent.getStu_tel());
			pstmt.setDate(6, birth);
			
			insertCount = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return insertCount;
	}

	public ArrayList<Student> selectAllStudent() {
		
		ArrayList<Student> students = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student";
		
		try{
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				students.add(new Student(rs.getInt("stu_no"),
						rs.getString("stu_name"),
						rs.getInt("stu_year"),
						rs.getString("stu_addr"),
						rs.getString("stu_tel"),
						rs.getDate("stu_birth").toString()));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		
		return students;
	}

	public int modifyStudent(Student student, Date birth) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update student set stu_name=?, stu_year=?, stu_addr=?, stu_tel=?, stu_birth=? where stu_no=?;";
		
		System.out.println(student.toString());
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getStu_name());
			pstmt.setInt(2, student.getStu_year());
			pstmt.setString(3, student.getStu_addr());
			pstmt.setString(4, student.getStu_tel());
			pstmt.setDate(5, birth);
			pstmt.setInt(6, student.getStu_no());
			
			insertCount = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return insertCount;
	}

	public int deleteStudent(int stu_no) {
		PreparedStatement pstmt = null;
		int delete = 0;
		String sql = "DELETE FROM student WHERE stu_no=?";
		
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stu_no);
			
			delete = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return delete;
	}
}
