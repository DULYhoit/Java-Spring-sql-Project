package ex14.marray;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		int[][] kors = new int[3][3];
		int[] total = new int[3];
		float[] avg = new float[3];
		int menu;


		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				kors[i][j] = 0;
			}
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
			case 1:
				// ------성적 입력 부분---------------------
				System.out.println("┌──────────────────┐");
				System.out.println("│     성적 입력      │");
				System.out.println("└──────────────────┘");

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						do {
							System.out.print((i + 1) + "학년 " + "국어" + (j + 1) + ": ");
							kors[i][j] = scan.nextInt();
							if (kors[i][j] < 0 || 100 < kors[i][j])
								System.out.println("성적범위(0~100)를 벗어났습니다.");
						} while (kors[i][j] < 0 || 100 < kors[i][j]);

					}

				}

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						total[i]+=kors[i][j];
					}
				}
					
				for (int i = 0; i < 3; i++) {
				avg[i] = total[i] / 3.0f;
				}

				break;

			case 2:
				// ------성적 출력 부분---------------------
				System.out.println("┌──────────────────┐");
				System.out.println("│     성적 출력      │");
				System.out.println("└──────────────────┘");

				for (int i = 0; i < 3; i++) {
					System.out.println((i+1)+"학년 성적표");
					for(int j=0; j<3; j++) {
						System.out.println("국어"+(j+1)+":"+kors[i][j]);
					
						
					}
					System.out.println("\t총점 : " + total[i]);
					System.out.printf("\t평균 : %5.1f\n", avg[i]);
					System.out.println("────────────────────");
				}
				break;

			case 3:
				// System.exit(0); <-프로세스를 종료하는 함수 (강제) 비추천
				break 종료;

			default:
				System.out.println("1~3까지만입력해주세요");

			}
		}
		// System.out.println("good bye~");
	}

}
