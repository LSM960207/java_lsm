package day2;

public class Ex3_Arithmetic {

	public static void main(String[] args) {
		/* 산술 연산자 주의사항1 : 나누기할 때 소수점 사라지는 현상 조심할 것
		 * 
		 * 정수 연산자 정수 = 정수
		 * 5 + 2 =7
		 * 5 - 2 = 3
		 * 5 * 2 = 10
		 * 5 % 2 = 1	<< 나머지를 출력,
		 * 5 / 2 = 2	<< 나머지 떨어져 나가버림
		 * 
		 * 정수 연산자 실수 = 실수
		 * 실수 연산자 실수 = 실수
		 * 실수 연산자 실수 = 실수
		 * 결과 값이 어떤 수 
		 */
		
		System.out.println(5 + 2);
		System.out.println(5 - 2);
		System.out.println(5 * 2);
		System.out.println(5 % 2);
		System.out.println(5 / 2);
		System.out.println(5 / 2.0); // 소수점까지 찍어주거나
		System.out.println(5 / (double)2); // 타입변환을 해준다
		
		// 산술 연산자 주의사항2 : 0으로 나누는 경우 예외(Exception)가 발생할 수 있음 >> 정수 / 0인 경우
		System.out.println(5 / 0.0);	// infinity로 나옴
		System.out.println(5 % 0);		// 나머지 연산자도 0으로 나누는 경우 예외
		System.out.println(5 / 0);		// 0으로 나누는 경우 예외
	}

}
