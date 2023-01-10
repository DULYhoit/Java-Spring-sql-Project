
public class Program {

	public static void main(String[] args) {
		//예외처리 방법2개
		//1. try catch로 오류를 직접 처리
		//2.RuntimeException을 상속받아 런타임과정에서 알아서처리 (extends RuntimeException)
		Calculator calc = new Calculator();
		int result = 0;
		try {
			result = Calculator.add(3,1004);
			System.out.printf("add  : %d\n", result);
			
			result = Calculator.sub(3,4);
			System.out.printf("sub : %d\n", result);
			
		}catch(천을_넘는_예외 e) {
			//특화된 처리하고싶은경우
			System.out.println("특화된처리");
		}
		catch(Exception e) {
			//부모인 Exception을 사용하면 특정조건이나닌 무조건 실행되는 예외
			//일괄처리 하고싶은경우
			System.out.println("음수처리");
		}
		finally {
			System.out.println("입력 값에 오류가 있습니다.");
		}
			
		result = Calculator.multi(3,4);
		System.out.printf("multi : %d\n", result);
		result = Calculator.div(3,4);
		System.out.printf("div : %d\n", result);
		
		

	}

}
