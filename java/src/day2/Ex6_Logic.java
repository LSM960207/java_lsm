package day2;

public class Ex6_Logic {

	public static void main(String[] args) {
		/* AND : &&, ~하고 ~이고 / 둘 다 참이면 참, 하나라도 거짓이면 거짓
		 * OR : ||, ~하거나 ~이거나 / 둘 다 거짓이면 거짓, 하나라도 참이면 참
		 * XOR : ^ / 둘 다 같으면 거짓, 다르면 참
		 * NOT : ! / 참은 거짓, 거짓은 참
		 * 결과값이 참 또는 거짓 => 조건식
		 */
		
		/* 성적이 A학점인가? A학점의 기준 => 90점 이상이고 100점 이하
		 * score가 90점 이상"이고", score가 100점 이하이다
		 * score가 90점 이상 && score가 100점 이하
		 * score >= 90 && score <= 100
		 */
		int score = 105; // 1차 : 89점에서 95로 변경		2차 : 95점에서 105로 변경
		System.out.println(score + "점은 A학점인가? " + (score >= 90 && score <= 100));
		
		/* 잘못된 성적인가? 유효한 성적은 성적이 0점 이상 100점 이하
		 * 잘못된 성적은 성적이 0점 미만"이거나" 100점 초과
		 * 성적이 0점 미만 || 성적이 100점 초과
		 * score < 0 || score > 100
		 * */
		System.out.println(score + "점은 잘못된 성적인가? " + (score < 0 || score > 100));
		
		/* 유효한 성적인가? 잘못된 성적의 "반대"
		 * */
		System.out.println(score + "점은 유효한 성적인가? " + !(score < 0 || score > 100));
		
	}

}
