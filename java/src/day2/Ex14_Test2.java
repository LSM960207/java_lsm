package day2;

public class Ex14_Test2 {

	public static void main(String[] args) {
		/* 성적에 맞는 학점을 출력하는 코드를 작성하세요
		 * A : 90 이상 ~ 100 이하
		 * B : 80 이상 ~ 90 미만
		 * C : 70 이상 ~ 80 미만
		 * D : 60 이상 ~ 70 미만
		 * F : 0 이상 ~ 60 미만
		 * 0 미만이거나, 100 초과인 경우 잘못된 성적이라고 출력하도록 수정하세요
		 * */
		
		int score = 1234567890;			//더욱 간결히 할 수 있다. 효율적인 코드
		if(score < 0 || score > 100 ) {
			System.out.println(score + "점은 잘못된 성적");
		}
			else if(score >= 90) {
				System.out.println(score + "점은 A학점");
		}
			else if(score >= 80) {
				System.out.println(score + "점은 B학점");
		}
			else if(score >= 70) {
				System.out.println(score + "점은 C학점");
		}
			else if(score >= 60) {
				System.out.println(score + "점은 D학점");
		}
			else {
				System.out.println(score + "점은 F학점");
		}
		}
}
