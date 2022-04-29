package day5;

import java.util.Scanner;

public class Ex5_DoWhile2_UpDown {

	public static void main(String[] args) {
		/* 랜덤으로 생성한 수(1~100)를 맞추는 게임을 작성하세요.
		 * 정수를 입력했을 때 입력한 정수보다 랜덤으로 생성된 수가 크면 UP, 작으면 DOWN을 표시하고
		 * 맞으면 맞췄습니다 라고 표시
		 * 랜덤으로 생성한 수 : 40
		 * 입력 : 100
		 * DOWN
		 * 입력 : 50
		 * DOWN
		 * 입력 : 25
		 * UP
		 * 입력 : 40
		 * 정답입니다.
		 * 
		 * 반복횟수 : 무한대
		 * 규칙성 : 정수를 입력받고, 
		 * 			입력받은 정수 num가 랜덤한 수 r과 같으면 정답입니다. 라고 출력한 후 반복문을 빠져나가고,
		 * 			입력받은 정수 num가 랜덤한 수 r과 같지 않고 r보다 작으면  DOWN이라고 출력하고,
		 * 			입력받은 정수 num가 랜덤한 수 r과 같거나 크지 않으면 UP이라고 출력
		 * */
		
		
		int min = 1, max = 100;
		int r = (int)(Math.random() * (max - min + 1) + min);;
		Scanner scan = new Scanner(System.in);
		int num;
		
		System.out.println("랜덤으로 생성한 수 (1~100) : " + r);
		
		do {
			System.out.println("1~100사이의 정수를 입력하세요 : ");
			num = scan.nextInt();
			if(num < 1 || num > 101) {
				continue;
			}if(num > r) {
				System.out.println("DOWN");
			}else if(num < r){
				System.out.println("UP");
			}
		}while(num != r);
		System.out.println("정답입니다.");
		scan.close();
	}

}
