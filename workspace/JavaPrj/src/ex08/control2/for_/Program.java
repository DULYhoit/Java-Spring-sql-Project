package ex08.control2.for_;

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
			//------성적 출력 부분---------------------
			System.out.println("┌──────────────────┐");
			System.out.println("│     성적 출력      │");
			System.out.println("└──────────────────┘");

			for(int i=0;i<3;i++) {
				System.out.println("국어"+(i+1)+":");
			}
			System.out.println("\t총점 : "+total);
			System.out.printf("\t평균 : %5.1f\n",avg);
			System.out.println("────────────────────");

		}
	}
	//tip:while은 조건을위한 반복
	//tip:for는 특정한 횟수를 반복

}
