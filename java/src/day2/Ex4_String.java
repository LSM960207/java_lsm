package day2;

public class Ex4_String {

	public static void main(String[] args) {
		/* 문자열 + 문자열 => 문자열
		 * 문자열 + 정수 => 문자열
		 * 문자열 + 문자 => 문자열
		 * 문자열 + 실수 => 문자열
		 */
		String str = "Hello";		// String은 앞글자 대문자로
		str = str + " world";		// ""는 문자열
		System.out.println(str);
		
		str = str + '!';			// "는 문자
		System.out.println(str);
		
		str = str + 123;
		System.out.println(str);
		
		str = str + 3.45;
		System.out.println(str);
		
		str = str + true;
		System.out.println(str);
	}

}
