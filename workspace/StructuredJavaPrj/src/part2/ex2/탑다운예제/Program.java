package part2.ex2.탑다운예제;

public class Program {

	public static void main(String[] args) {
		int[][] lottos = null;
		int menu;
		boolean running = true;

		menu = inputMenu();

		while (running) {

			switch (menu) {
			case 1:
				// 로또 자동생성
				lottos = crateLottosAuto();
				break;
			case 2:
				// 로또 수동생성
				lottos = createLottosManual();
				break;
			case 3:
				printLottos(lottos);
				break;
			case 4:
				running = false;
				break;

			default:
				break;
			}

		}
	}

	private static void printLottos(int[][] lottos) {
		// TODO Auto-generated method stub
		
	}

	private static int[][] createLottosManual() {
		// TODO Auto-generated method stub
		return null;
	}

	private static int[][] crateLottosAuto() {
		// TODO Auto-generated method stub
		return null;
	}

	private static int inputMenu() {
		
		return 0;
	}

}
