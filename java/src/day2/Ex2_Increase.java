package day2;

public class Ex2_Increase {

	public static void main(String[] args) {
		/* 증감 연산자 : 최종적으로 1 증가 또는 1 감소
		 * 전위형 : ++변수명, 증가 후에 동작
		 * 후위형 : 변수명++, 동작 후에 증가
		*/
		int num1 = 10, num2 = 10;
		// num1 : 전위형, num2 : 후위형
		System.out.println(num1 + " , " + num2);
		System.out.println(++num1 + " , " + num2++);
		// num1 = 10이지만 전위형이라 1 증가한 11로 프린트됨
		// num2 = 10이지만 후위형이라 프린트 된 이후 다음 줄부터 1 증가함
		System.out.println(num1 + " , " + num2);
		
		int num3 = 10, num4 = 10;			// 헷갈리는 경우 나눠서 작업하는 걸 추천
		// num3 : 전위형, num4 : 후위형
		System.out.println(num3 + " , " + num4);
		num3++;		// ++num3;		//num3 = num3 + 1;
		System.out.println(num3 + " , " + num4);
		num4++;		// ++num4;		//num4 = num4 + 1;
		System.out.println(num3 + " , " + num4);
	}

}
