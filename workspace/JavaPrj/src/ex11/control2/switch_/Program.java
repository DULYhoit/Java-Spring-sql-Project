package ex11.control2.switch_;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		int kor1 = 0, kor2, kor3;
		int total = 0;
		float avg = 0;
		int menu;

		byte b = (byte) 39;
		float x = (float) 3.5;

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
				do{
					System.out.print("국어1 :");
					kor1 = scan.nextInt();
					if(kor1<0 || 100<kor1)
						System.out.println("성적범위(0~100)를 벗어났습니다.");
				}while(kor1 <0 || 100<kor1); 

				do{
					System.out.print("국어2 :");
					kor2 = scan.nextInt();
					if(kor2<0 || 100<kor2)
						System.out.println("성적범위(0~100)를 벗어났습니다.");
				}while(kor2 <0 || 100<kor2); 

				do{
					System.out.print("국어3 :");
					kor3 = scan.nextInt();
					if(kor3<0 || 100<kor3)
						System.out.println("성적범위(0~100)를 벗어났습니다.");
				}while(kor3 <0 || 100<kor3); 

				total = kor1 + kor2 + kor3;
				avg = total / 3.0f;


				break;

			case 2:
				//------성적 출력 부분---------------------
				System.out.println("┌──────────────────┐");
				System.out.println("│     성적 출력      │");
				System.out.println("└──────────────────┘");

				for(int i=0;i<3;i++) {
					System.out.println("국어"+(i+1)+":" +kor1);
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
	//else if는 메인메뉴를 만들기에는 부적합한 제어문이다.
	
	
}









