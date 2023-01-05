package ex06.control1;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		int kor1, kor2, kor3;
		int total;
		float avg;

		byte b = (byte) 39;
		float x = (float) 3.5;

		while(true) {
			//------성적 입력 부분---------------------
			Scanner scan = new Scanner(System.in);
			System.out.print("국어1 :");
			kor1 = scan.nextInt();
			
			while(kor1 <0 || 100<kor1) {
				System.out.println("성적범위(0~100)를 벗어났습니다.");
				System.out.print("국어1 :");
				kor1 = scan.nextInt();
			}


			System.out.print("국어2 :");
			kor2 = scan.nextInt();
			System.out.print("국어3 :");
			kor3 = scan.nextInt();
			total = kor1 + kor2 + kor3;
			avg = total / 3.0f;
			//------성적 출력 부분---------------------
			System.out.println("┌──────────────────┐");
			System.out.println("│     성적 출력      │");
			System.out.println("└──────────────────┘");

			System.out.printf("\t국어1 : %d\n",kor1);
			System.out.println("\t국어2 : 0"+kor2);
			System.out.println("\t국어3 : 0"+kor3);
			System.out.println("\t총점 : "+total);
			System.out.printf("\t평균 : %5.1f\n",avg);
			System.out.println("────────────────────");

		}
	}

}
