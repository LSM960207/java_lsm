package day3;

public class Ex13_For4_Sum {

	public static void main(String[] args) {
		/* 1부터 5까지 합을 구하는 코드를 작성하세요.
		 * 			sum = 0
		 * i = 1	sum = 0 + 1
		 * i = 2	sum = 0 + 1 + 2
		 * i = 3	sum = 0 + 1 + 2 + 3
		 * i = 4	sum = 0 + 1 + 2 + 3 + 4
		 * i = 5	sum = 0 + 1 + 2 + 3 + 4 + 5
		 * 
		 * 			sum0 = 0
		 * i = 1	sum1 = sum0 + 1
		 * i = 2	sum2 = sum1 + 2
		 * i = 3	sum3 = sum2 + 3
		 * i = 4	sum4 = sum3 + 4
		 * i = 5	sum5 = sum4 + 5
		 * 
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : 
		 * 반복문 종료 후 : sum을 출력
		 * */
		
		int i;
		int sum = 0;
		for(i = 1; i <=5; i++) {
			sum +=i; // sum = sum + i;
		}
		System.out.println("1부터 5까지의 합은 : " + sum);
	}
}

