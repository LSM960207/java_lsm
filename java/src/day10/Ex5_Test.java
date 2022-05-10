package day10;

import java.util.Scanner;

public class Ex5_Test {

	public static void main(String[] args) {
		int menu = -1;
		Scanner scan = new Scanner(System.in);
		Student std = new Student("",0,0,0);
		for (; menu != 3;) {
			System.out.println("메뉴");
			System.out.println("1. 학생 정보 입력");
			System.out.println("2. 학생 정보 출력");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
			scan.nextLine();

			switch (menu) {
			case 1:
				System.out.print("이름 : ");
				String name = scan.nextLine();
				System.out.print("학년 : ");
				int grade = scan.nextInt();
				System.out.print("반 : ");
				int classNumber = scan.nextInt();
				System.out.print("번호 : ");
				int number = scan.nextInt();
				std = new Student(name, grade, classNumber, number);
				break;
			case 2:
				std.print();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}
		scan.close();

	}

}

class Student {
	// 학생이름, 학년, 반, 번호
	String name;
	int grade;
	int classNumber;
	int number;


	void print() {
		System.out.println(grade + "학년 " + classNumber + "반 " + number + "번 " + name);
	}
	public Student(String name, int grade, int classNumber, int number) {
		super();
		this.name = name;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
	}
}