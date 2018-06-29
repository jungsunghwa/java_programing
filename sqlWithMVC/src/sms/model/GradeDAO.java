package sms.model;

import static sms.db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sms.dto.Grade;
import sms.dto.Student;

public class GradeDAO {
	
	Connection con;
	StudentDAO stuDAO;
	
	public GradeDAO(Connection con) {
		this.con = con;
		stuDAO = new StudentDAO(con);
	}
	
	public int addGrade(Grade grade) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into grade values (?,?,?,?);";
		
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, grade.getStu_no());
			pstmt.setInt(2, grade.getGrade_kor());
			pstmt.setInt(3, grade.getGrade_eng());
			pstmt.setInt(4, grade.getGrade_math());
			
			insertCount = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return insertCount;
	}

	public Grade selectGrade(int stu_no) {
		Grade grade = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM grade WHERE stu_no=?";
		
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stu_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				grade = new Grade(rs.getInt("stu_no"),
						stuDAO.selectStudent(rs.getInt("stu_no")).getStu_name(),
						rs.getInt("grade_kor"),
						rs.getInt("grade_eng"),
						rs.getInt("grade_math"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		
		return grade;
	}

	public ArrayList<Grade> selectAllStudent() {
		
		ArrayList<Grade> grades = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM grade";
		
		try{
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				grades.add(new Grade(rs.getInt("stu_no"),
						stuDAO.selectStudent(rs.getInt("stu_no")).getStu_name(),
						rs.getInt("grade_kor"),
						rs.getInt("grade_eng"),
						rs.getInt("grade_math")));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		
		return grades;
	}

	public int modifyGrade(Grade grade) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update grade set stu_no=?, grade_kor=?, grade_eng=?, grade_math=? where stu_no=?;";
		
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, grade.getStu_no());
			pstmt.setInt(2, grade.getGrade_kor());
			pstmt.setInt(3, grade.getGrade_eng());
			pstmt.setInt(4, grade.getGrade_math());
			pstmt.setInt(5, grade.getStu_no());
			
			insertCount = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return insertCount;
	}

	public int deleteGrade(int stu_no) {
		PreparedStatement pstmt = null;
		int delete = 0;
		String sql = "DELETE FROM grade WHERE stu_no=?";
		
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
