package ex02.io.printstream;

public class Program {

	public static void main(String[] args) {

		int kor1, kor2, kor3;
		int total;
		float avg;

		byte b = (byte) 39;
		float x = (float) 3.5;

		kor1 = 10;
		kor2 = 20;
		kor3 = 30;

		total = kor1 + kor2 + kor3;
		avg = total / 3;
		//------성적 출력 부분---------------------
		System.out.print("┌──────────────────┐");
		System.out.print("│     성적 출력      ㅣ");
		System.out.print("└──────────────────┘");

		System.out.println("국어1 : 0");
		System.out.println("국어2 : 0");
		System.out.println("국어3 : 0");
		System.out.println("총점 : 0");
		System.out.println("평균 : 0.00");
		System.out.print("────────────────────");
	}

}
