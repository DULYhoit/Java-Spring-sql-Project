package part3.ex5.추상화;

import java.util.Scanner;

public abstract class ExamConsole {
	/*
	 * composition has A 관계는 강한 결속 , aggregation has a 는 약한 결속,
	 *  composition has a는
	 * 생성될 때 생성자로서 바로 생성, aggregation has a 는 참조 
	 * 변수만 만들어 놓고나중에 투입되므로 생성시기가 다를 수 있음.
	 */
	//Composition Has A 일체형
	private ExamList list = new ExamList();
	//전역필드에 연산자를 못썼음 원래방법은 아래
//	private ExamList list
//	public ExamConsole() {
//		list = new ExamList();
//	}
	void print() {
		this.print(list.size());

	}
	

	void print(int size) {
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력            │");
		System.out.println("└──────────────────┘");
		System.out.println();

//				int size = list.current;
//		Exam[] exams = this.exams;
		for (int i = 0; i < size; i++) {
			Exam exam = list.get(i);
			int kor = exam.getKor();
			int eng = exam.getEng();
			int math = exam.getMath();
			int total = exam.total();
			float avg = exam.avg();

			System.out.printf("국어 : %3d\n", kor);
			System.out.printf("영어 : %3d\n", eng);
			System.out.printf("수학 : %3d\n", math);
			onPrint(exam);
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("────────────────────────");

		}

	}

	
	


	void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 입력            │");
		System.out.println("└──────────────────┘");
		System.out.println();

		int kor, eng, math;

		do {
			System.out.printf("국어 : ");
			kor = scan.nextInt();

			if (kor < 0 || 100 < kor) {
				System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
			}
		} while (kor < 0 || 100 < kor);
		do {
			System.out.printf("영어 : ");
			eng = scan.nextInt();

			if (eng < 0 || 100 < eng) {
				System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
			}
		} while (eng < 0 || 100 < eng);
		do {
			System.out.printf("수학 : ");
			math = scan.nextInt();

			if (math < 0 || 100 < math) {
				System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
			}
		} while (math < 0 || 100 < math);
		
//		Exam exam = new Exam();
//		exam.setKor(kor);
//		exam.setEng(eng);
//		exam.setMath(math);
//		Exam exam = new Exam(kor,eng,math);
		Exam exam = makeExam();
		exam.setKor(kor);
		exam.setEng(eng);
		exam.setMath(math);
		onInput(exam);
		/*--add-------------------------------------*/
		
		list.add(exam);
		
	
		

	}


	protected abstract void onPrint(Exam exam);
	protected abstract void onInput(Exam exam);

	protected abstract Exam makeExam();
}
