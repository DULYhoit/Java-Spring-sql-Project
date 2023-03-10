package ex15.finalvar;

import java.util.Iterator;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		final int SIZE = 3;
		int[] kors = new int[SIZE];
		int total = 0;
		float avg = 0;
		int menu; // 1:INPUT, 2:PRINT, 3:EXIT
		final int MENU_INPUT = 1;
		final int MENU_PRINT = 2;
		final int MENU_EXIT = 3;
		for(int i=0; i<SIZE; i++) {
			kors[i]=0;
		}

		종료: while (true) {
			Scanner scan = new Scanner(System.in);
			// ------메인 메뉴 부분---------------------
			System.out.println("┌──────────────────┐");
			System.out.println("│     메인 메뉴      │");
			System.out.println("└──────────────────┘");
			System.out.println("1.성적입력");
			System.out.println("2.성적출력");
			System.out.println("3.종료");
			System.out.println(">");
			menu = scan.nextInt();
			switch (menu) {
			case MENU_INPUT:
				// ------성적 입력 부분---------------------
				System.out.println("┌──────────────────┐");
				System.out.println("│     성적 입력      │");
				System.out.println("└──────────────────┘");

				for (int i = 0; i < SIZE; i++) {
					do {
						System.out.print("국어" + (i + 1) + ": ");
						kors[i] = scan.nextInt();
						if (kors[i] < 0 || 100 < kors[i])
							System.out.println("성적범위(0~100)를 벗어났습니다.");
					} while (kors[i] < 0 || 100 < kors[i]);

				}
				for (int i = 0; i < SIZE; i++) {
					total += kors[i];
				}
				avg = total / 3.0f;

				break;

			case MENU_PRINT:
				// ------성적 출력 부분---------------------
				System.out.println("┌──────────────────┐");
				System.out.println("│     성적 출력      │");
				System.out.println("└──────────────────┘");

				for (int i = 0; i < SIZE; i++) {
					System.out.println("국어" + (i + 1) + ":" + kors[i]);
				}
				System.out.println("\t총점 : " + total);
				System.out.printf("\t평균 : %5.1f\n", avg);
				System.out.println("────────────────────");
				break;

			case MENU_EXIT:
				// System.exit(0); <-프로세스를 종료하는 함수 (강제) 비추천
				break 종료;

			default:
				System.out.println("1~3까지만입력해주세요");

			}
		}
		// System.out.println("good bye~");
	}

}
