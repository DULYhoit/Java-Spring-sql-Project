package part3.ex1.캡슐화;

import java.util.Scanner;

public class ExamList {
		//Exam class의 성적정보를 참조하는 배열과 crrent를 묶음
	
		Exam[] exams;
		int current;
		
		static void printList(ExamList list) {

			printList(list, list.current);
		}

		static void printList(ExamList list, int size) {
			System.out.println("┌──────────────────┐");
			System.out.println("│     성적 출력            │");
			System.out.println("└──────────────────┘");
			System.out.println();

//				int size = list.current;
			Exam[] exams = list.exams;
			for (int i = 0; i < size; i++) {
				Exam exam = exams[i];
				int total = exam.kor + exam.eng + exam.math;
				float avg = total / 3.0f;
				int kor = exam.kor;
				int eng = exam.eng;
				int math = exam.math;

				System.out.printf("국어 : %3d\n", kor);
				System.out.printf("영어 : %3d\n", eng);
				System.out.printf("수학 : %3d\n", math);
				System.out.printf("총점 : %3d\n", total);
				System.out.printf("평균 : %6.2f\n", avg);
				System.out.println("────────────────────────");

			}

		}

		static void inputList(ExamList list) {
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
			Exam exam = new Exam();
			exam.kor = kor;
			exam.eng = eng;
			exam.math = math;

			Exam[] exams = list.exams;
			int size = list.current;

			if (exams.length == size) {
				// 가변배열 만들기
				// 1.새로운 배열을 생성
				Exam[] temp = new Exam[size + 5];
				// 2.exams[0 ,1 ,2].변수 값들을 temp에 이주시키기
				for (int i = 0; i < size; i++) {
					temp[i] = exams[i];
				}
				// 3.list.exams가 새로만든 temp 배열을 참조 할수있도록 한다.
				list.exams = temp;

			}
			list.exams[list.current] = exam;

			System.out.println("────────────────────────");
			list.current++;

		}
		
		public static void init(ExamList list) {
			list.exams = new Exam[3];
			list.current = 0;
			
		}

	

}
