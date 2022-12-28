package ex3.io.escape;

public class Program {

	public static void main(String[] args) {

		int kor1, kor2, kor3;
		int total;
		float avg;

		byte b = (byte) 39;
		float x = (float) 3.5;

		kor1 = 50;
		kor2 = 60;
		kor3 = 80;

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
