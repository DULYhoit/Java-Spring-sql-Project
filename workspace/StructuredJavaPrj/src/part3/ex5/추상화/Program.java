package part3.ex5.추상화;

import java.util.Iterator;
import java.util.Scanner;

public class Program {

	public static void main(String[] args){
		//현재 ExamConsole과 Exam클래스는 abstract 추상클래스라서 상속받아서 써야함
		Console list = new Console();

		int menu;

		boolean keepLoop = true;

		while (keepLoop) {

			menu = inputMenu();
			switch (menu) {
			case 1:

				// ExamList.inputList(list);
				list.onInput(null);
				break;
			case 2:
				// ExamList.printList(list);
				list.onPrint(null);
				break;
			case 3:
				System.out.println("Bye~~");

				keepLoop = false;
				break;

			default:
				System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
			}
		}
	}

	static int inputMenu() {

		Scanner scan = new Scanner(System.in);

		System.out.println("┌──────────────────┐");
		System.out.println("│     메인 메뉴            │");
		System.out.println("└──────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.println("\t선택> ");
		int menu = scan.nextInt();
		return menu;
	}

}
