package day5;

public class Ex6_NestedLoop1 {

	public static void main(String[] args) {
		/* *****
		 * *****
		 * *****
		 * 
		 * */
		for(int i = 1; i <= 3; i++) {
			// *을 5개 출력하는 코드 => *을 j개 출력하는 코드
			// System.out.println("*****");
			// *을 10개 출력하고 엔터치는 반복문 코드로 수정
			// *을 10개 반복문으로 한 줄에 출력
			for(int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			// 엔터
			System.out.println();
		}

	}
}