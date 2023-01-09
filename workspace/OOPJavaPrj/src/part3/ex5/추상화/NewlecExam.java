package part3.ex5.추상화;

public class NewlecExam extends Exam {
	private int com;

	public NewlecExam() {
		this(0,0,0,0);
	}

	public NewlecExam(int kor, int eng, int math, int com) {
		super(0,0,0);
		this.com = com;
	}
	
	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public int total() {
		int total = ontotal()+com;
		return total;
	}

	@Override
	public float avg() {
		
		return total()/4.0f;
	}

}
