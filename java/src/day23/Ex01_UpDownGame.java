package day23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_UpDownGame {

	public static void main(String[] args) {
		/*  - 1~100 사이의 랜덤한 수를 맞추는 Up Down 게임을 프로그램을 작성하세요
		 *  - 기록을 저장하는 기능을 추가
		 *  - 기록은 최대 5등까지
		 *  - 5등 이내의 기록은 이름을 기록하여 저장
		 *  - 한 사람이 여러 기록을 가질 수 있다
		 *  - 같은 기록일 경우 기록된 순서대로
		 *  - 잘못된 정수를 입력해도 시도한 걸로 인정
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료 
		 * */
		Scanner scan = new Scanner(System.in);
		int min = 1, max = 100;
		int menu = -1;
		int user;
		List<Record> list = new ArrayList<Record>();
		list.add(new Record(1, "일길동"));
		list.add(new Record(7, "이길동"));
		list.add(new Record(8, "삼길동"));
		//list.add(new Record(9, "사길동"));
		//list.add(new Record(10, "오길동"));
		
		do {
			System.out.println("1. 플레이");
			System.out.println("2. 기록 확인");
			System.out.println("3. 게임 종료");
			System.out.print("메뉴 선택 : ");
			
			//원하는 메뉴 입력
			menu = scan.nextInt();
			
			//입력받은 메뉴 실행
			switch(menu) {
			//1번 메뉴 : 플레이
			case 1:		
				//랜덤한 수 생성
				int r = (int)(Math.random() * (max - min + 1) + min);;
				int count = 0;	//시도 횟수
				//랜덤으로 생성한 수 테스트 
				System.out.println("랜덤으로 생성한 수 (1~100) : " + r);
				user = 0;
				while(true){
					System.out.print("1~100 사이의 정수를 입력하세요 : ");
					//사용자 입력
					user = scan.nextInt(); 
					count++;
					//잘못된 수를 입력했을 때
					if(user < 1 || user > 100) {
						continue;
					}
					//정답일 때
					if(user == r) {
						System.out.println("정답입니다!");	
						break; 
					}
					//클 때
					else if(user > r) {
						System.out.println("DOWN");
					}
					//작을 때
					else {
						System.out.println("UP");
					}					
				}
				//기록 확인
				//새 기록이면 (5등 이내)
				//이름을 입력하고 저장
				int i;
				for(i = 0; i < list.size(); i++) {
					if(list.get(i).getCount() > count) {
						break;
					}
				}
				/* list.size() < 5 : 저장된 기록이 5개 미만
				 * i < list.size() : 저장된 기록이 5개 이상 중에 지금 플레이한 횟수가 등수에 포함될 때
				 * 					 위에 break가 동작하면 i는 list.size()보다 작고
				 * 					 break가 동작하지 않으면 i는 list.size()  */
				if(list.size() < 5 || i < list.size()) {
					System.out.println("새로운 기록이 달성됐습니다. 기록을 저장하세요.");
					System.out.print("이름 : ");
					
					list.add(i, new Record(count, scan.next()));
					list = list.subList(0, list.size()>5 ? 5 : list.size());
				}
				break;
			//2번 메뉴 : 기록 확인
			case 2:
				for(int j = 0; j < list.size(); j++) {
					System.out.println(j+1+ "." + list.get(j));
				}
				
				break;
			//3번 메뉴 : 게임 종료	
			case 3:
				System.out.println("게임을 종료합니다.");
				break;
			default:
				System.out.println("1~3 사이의 메뉴를 선택하세요.");
			}
			
		}while(menu != 3);
		scan.close();
	}

}
class Record {
	private int count;
	String name;
	
	public Record(int count, String name) {
		this.count = count;
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "[ " + name + " : " + count + "]";
	}
	
}