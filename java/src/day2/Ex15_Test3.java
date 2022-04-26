package day2;

public class Ex15_Test3 {

	public static void main(String[] args) {
		/* month가 주어질 때 해당 달의 마지막 일을 출력하는 코드를 if문으로 작성하세요.
		 * 31일 : 1 3 5 7 8 10 12
		 * 30일 : 4 6 9 11
		 * 28일 : 2
		 * 그 외의 달은 "잘못된 월입니다"라고 출력
		 * */

		/* 내가 짠 코드
		int month = 1;
		if(month == 2) {
			System.out.println(month + "월의 마지막 일은 28일입니다");
		}else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				System.out.println(month + "월의 마지막 일은 31일입니다");
		}else if(month == 4 || month == 6 || month == 9 || month == 11) {
				System.out.println(month + "월의 마지막 일은 30일입니다");
		}else{System.out.println(month + "월은 잘못된 월입니다");
		}
		*/
		
		// 강사님이 짠 코드
		int month = 1;
		if(month < 1 || month > 12) {
			System.out.println(month + "월은 잘못된 월입니다");
		} else if(month == 2) {
			System.out.println(month + "월의 마지막 일은 28일입니다");
		} else if(month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println(month + "월의 마지막 일은 30일입니다");
		} else {
			System.out.println(month + "월의 마지막 일은 31일입니다.");
		}
	}
}
	
