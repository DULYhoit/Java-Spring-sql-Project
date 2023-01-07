package part3.ex4.UI코드분리하기;

import java.util.Scanner;

public class ExamList {
	// Exam class의 성적정보를 참조하는 배열과 crrent를 묶음
	private Exam[] exams;
	private int current;

	public ExamList() {

		exams = new Exam[3];
		current = 0;
	}

	public Exam get(int i) {
		// TODO Auto-generated method stub
		return this.exams[i];
	}

	public void add(Exam exam) {
		Exam[] exams = this.exams;
		int size = current;

		if (exams.length == size) {
			// 가변배열 만들기
			// 1.새로운 배열을 생성
			Exam[] temp = new Exam[size + 5];
			// 2.exams[0 ,1 ,2].변수 값들을 temp에 이주시키기
			for (int i = 0; i < size; i++) {
				temp[i] = exams[i];
			}
			// 3.list.exams가 새로만든 temp 배열을 참조 할수있도록 한다.
			exams = temp;

		}
		exams[current] = exam;

		System.out.println("────────────────────────");
		current++;

	}

	public int size() {
		// TODO Auto-generated method stub
		return current;
	}

}
