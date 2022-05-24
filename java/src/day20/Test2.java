package day20;

import java.util.*;

public class Test2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		int exitMenu = 4;
		int menu;
		do {
			// 메뉴 출력
			System.out.println("메뉴");
			System.out.println("1. 파일 저장");
			System.out.println("2. 파일 확인");
			System.out.println("3. 파일 검색");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴 선택 : ");

			// 입력
			menu = scan.nextInt();
			// 기능 수행
			switch (menu) {
			// 1번 : 파일 저장
			case 1:
				System.out.print("파일명 : ");
				// 파일명 입력
				String fileName = scan.next();
				list.add(fileName);
				break;
			// 2번 : 파일 확인
			case 2:
				for (String tmp : list) {
					System.out.println(tmp);
				}
				break;
			// 3번 : 파일 검색
			case 3:
				System.out.print("검색어 : ");
				String search = scan.next();
				System.out.println("검색 결과");
				for (String tmp : list) {
					if (tmp.contains(search)) {
						System.out.println(tmp);
					}
				}

				break;
			// 프로그램 종료
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
			}

		} while (menu != exitMenu);

		scan.close();
	}
}