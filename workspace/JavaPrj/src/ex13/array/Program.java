package ex13.array;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		
		int[] kors = new int[3];
		int total = 0;
		float avg = 0;
		int menu;

		

		종료:
		while(true) {
			Scanner scan = new Scanner(System.in);
			//------메인 메뉴 부분---------------------
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
				//------성적 입력 부분---------------------
				System.out.println("┌──────────────────┐");
				System.out.println("│     성적 입력      │");
				System.out.println("└──────────────────┘");
				
				for(int i=0;i<3;i++) {
					do{
						System.out.print("국어"+(i+1)+": ");
						kors[i] = scan.nextInt();
						if(kors[i]<0 || 100<kors[i])
							System.out.println("성적범위(0~100)를 벗어났습니다.");
					}while(kors[i] <0 || 100<kors[i]); 
					
				}

				total = kors[0] + kors[1] + kors[2];
				avg = total / 3.0f;


				break;

			case 2:
				//------성적 출력 부분---------------------
				System.out.println("┌──────────────────┐");
				System.out.println("│     성적 출력      │");
				System.out.println("└──────────────────┘");

				for(int i=0;i<3;i++) {
					System.out.println("국어"+(i+1)+":" +kors[i]);
				}
				System.out.println("\t총점 : "+total);
				System.out.printf("\t평균 : %5.1f\n",avg);
				System.out.println("────────────────────");
				break;

			case 3:
				//System.exit(0); <-프로세스를 종료하는 함수 (강제) 비추천
				break 종료;



			default:
				System.out.println("1~3까지만입력해주세요");

			}
		}
		//System.out.println("good bye~");
	}
	
	
	
}









