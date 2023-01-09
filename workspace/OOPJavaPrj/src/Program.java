import part3.ex4.UI코드분리하기.Exam;

public class Program {
	
	//배포과정
	//1.컴파일 -> Exam.class
	//2.압축 -> Exam.zip
	//3.jar -> Exam.jar

	public static void main(String[] args) {
		NewlecExam exam = new NewlecExam(10,20,30,40);
		
		System.out.println(exam.total());
		System.out.println(exam.avg());
	}

}
