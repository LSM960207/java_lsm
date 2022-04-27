package day3;

import java.util.Scanner;

public class Ex1_Scanner1 {

	public static void main(String[] args) {
		/* 한 학생의 수학, 영어, 국어 성적을 입력받고, 총점과 평균을 구하세요.
		 * 단, 성적은 정수로 입력받고 0~100 사이의 정수를 입력해야합니다.
		 * 테스트 성적 : 90 90 91*/
		
		System.out.println("점수를 입력하세요.(0 ~ 100) ");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수학 : ");
		int num1 = scan.nextInt();
		System.out.print("영어 : ");
		int num2 = scan.nextInt();
		System.out.print("국어 : ");
		int num3 = scan.nextInt();
		
		int sum = num1 + num2 + num3;
		System.out.println("세 과목의 총점은 " + sum + "점입니다.");
		double avg = sum / 3.0 ;
		System.out.println("세 과목의 평균은 " + avg + "점입니다.");
		
		scan.close();
	}

}
