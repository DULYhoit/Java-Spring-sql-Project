import part3.ex4.UI코드분리하기.Exam;

public class NewlecExam extends Exam {
	
	private int com;

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}
	
	@Override
	public int total() {
		
		return super.total()+com;
	}
	@Override
	public float avg() {
		// TODO Auto-generated method stub
		return total()/4.0f;
	}
}
