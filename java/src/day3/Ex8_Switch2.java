package day3;

public class Ex8_Switch2 {

	public static void main(String[] args) {
		/* 월이 주어졌을 때 주어진 월의 마지막 일을 출력하는 코드를 작성하세요. (Switch문)
		 * 31일 : 1 3 5 7 8 10 12
		 * 30일 : 4 6 9 11
		 * 28일 : 2
		 * */

		int month = 0;
		switch(month) {	
			case 1,3,5,7,8,10,12:
				System.out.println(month + "월의 마지막 일은 31일입니다");
				break;
			case 4,6,9,11:
				System.out.println(month + "월의 마지막 일은 30일입니다");
				break;
			case 2:
				System.out.println(month + "월의 마지막 일은 28일입니다");
			default :
				System.out.println(month + "월은 없는 달입니다");
	}
	}
}
