package ex12.control2.continue_break;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int n = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("값을 sp로 구분해서 5개 이상 입력하세요:");
		//scan.nextInt();
		//만약 34 5 6 234 enter의경우 첫번째오는 값을 읽게됨 두번째는 입력버퍼의 두번째를 읽게됨
		
		while (scan.hasNext()) {
			n = scan.nextInt();
			
			if(n<10)
				continue;
			
			if(n>200)
				break;
			
			System.out.println(n);
			
		}
	}

}
