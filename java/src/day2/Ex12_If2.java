package day2;

public class Ex12_If2 {

	public static void main(String[] args) {
		/* num가 짝수이면 짝수라고 출력하고, 짝수가 아니면 홀수라고 출력하는 코드를 if문을 이용하여 작성해보세요. 
		 * */
		int num = 4;
		// if문을 두 번 쓴 예제는 num가 홀수 / 짝수에 상관없이 무조건 두 번 비교를 합니다.
		if(num % 2 ==0) {
			System.out.println(num + "은 짝수");
		}
		if(num % 2 != 0) {
			System.out.println(num + "는 홀수");
		}
		
		// if else문을 이용한 예제는 num가 짝수면 한 번 비교하고, 홀수면 두 번 비교합니다.
		if(num % 2 == 0) {
			System.out.println(num + "은 짝수");
		}
		else {
			System.out.println(num + "은 홀수");
		}
	}

}
