package day4;

import java.util.Scanner;

public class Ex2_For2_Score {

	public static void main(String[] args) {
		/* 세 명의 국어 점수를 입력받아 총점과 평균을 구하는 코드를 작성하세요 (반복문 이용)
		 * 단, 총점과 평균만 알면 됨 => 총점과 평균을 구한 후 각 학생의 점수를 기억할 필요가 없다
		 * 반복문 활용이 잘 안되는 분은 반복문 없이 해보고 다 한 후 반복문으로 변경가능
		 * 
		 * 반복횟수 : 3번
		 * 규칙성 : 성적을 입력받고 총점에 누적
		 * 			Scanner를 이용하여 정수를 입력받아 num에 저장한 후,
		 * 			sum에 num을 더해서 sum에 저장
		 * 반복문 종료 후 : 총점을 출력하고, 총점을 이용하여 평균을 계산 후 출력
		 * 				sum을 출력하고, sum을 3으로 나누어 avg에 저장한 후, avg도 출력
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		int i, num, sum = 0;
		double avg;
		for(i = 1; i <= 3; i++) {
			num = scan.nextInt();
			sum = sum + num;	// sum += num;
		}
		System.out.println("총점은 " + sum + "점입니다.");
		avg = sum / (double)3;
		System.out.println("평균은 " + avg + "점입니다.");
			
		scan.close();
	}

}
