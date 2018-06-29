package sms.dto;

public class Grade {
	private int stu_no;
	private String stu_name;
	private int grade_kor;
	private int grade_eng;
	private int grade_math;
	private int total;
	private float avg;
	
	@Override
	public String toString(){
		return "학번: " + stu_no + ", 이름: " + stu_name + ", 국어: " + grade_kor + ", 영어: " + grade_eng + ", 수학: " + grade_math + ", 합계: " + total + ", 평균: " + avg;
	}

	public int getStu_no() {
		return stu_no;
	}

	public void setStu_no(int stu_no) {
		this.stu_no = stu_no;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public int getGrade_kor() {
		return grade_kor;
	}

	public void setGrade_kor(int grade_kor) {
		this.grade_kor = grade_kor;
	}

	public int getGrade_eng() {
		return grade_eng;
	}

	public void setGrade_eng(int grade_eng) {
		this.grade_eng = grade_eng;
	}

	public int getGrade_math() {
		return grade_math;
	}

	public void setGrade_math(int grade_math) {
		this.grade_math = grade_math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public Grade(int stu_no, String stu_name, int grade_kor, int grade_eng, int grade_math) {
		super();
		this.stu_no = stu_no;
		this.stu_name = stu_name;
		this.grade_kor = grade_kor;
		this.grade_eng = grade_eng;
		this.grade_math = grade_math;
		this.total = scoreTotal(grade_kor, grade_eng, grade_math);
		this.avg = scoreAvg(total);
	}

	private float scoreAvg(int total) {
		float avg=(float)total/3;
		avg = (float)Math.round(avg*100+0.5f)/100f;
		return avg;
	}

	public static void main(String[] args) {
		Grade grade = new Grade(10, "효성", 88, 29, 13);
		System.out.println(grade.scoreAvg(grade.total));
	}
	
	private int scoreTotal(int grade_kor, int grade_eng, int grade_math) {
		return grade_kor + grade_eng + grade_math;
	}
	
	
}
