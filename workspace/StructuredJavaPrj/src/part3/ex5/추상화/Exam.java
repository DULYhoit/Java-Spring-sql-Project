package part3.ex5.추상화;

public abstract class Exam {
	//성적정보 class
	private	int kor;
	private	int eng;
	private int math;
	
	public Exam() {
		this(0, 0, 0);
	}
	
	public Exam(int kor, int eng, int math) {
		
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public abstract int total();
	public abstract float avg();
	protected int ontotal() {
		
		return kor+eng+math;
	}
	
}
