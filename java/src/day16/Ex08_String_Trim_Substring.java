package day16;

public class Ex08_String_Trim_Substring {

	public static void main(String[] args) {
		String str = "\t\t\n\nabcdegf\n";
		System.out.println(str);
		System.out.println("----------");
		str = str.trim();			//앞뒤 공백 제거
		System.out.println(str);
		str = str.substring(1);		//1번지부터 끝까지
		System.out.println(str);
		str = str.substring(1,3);	//1번지부터 3번지 전까지(2번지까지)
		System.out.println(str);
	}

}
