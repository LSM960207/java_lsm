package day19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import day14.ConsoleProgram;
import day18.Student;

public class BoardManager implements ConsoleProgram {

	private Scanner scan;
	private List<Board> list;
	private int exitMenu = 4;

	public BoardManager() {
		scan = new Scanner(System.in);
		list = new ArrayList<Board>();
	}
	public BoardManager(Scanner scan) {
		this.scan = scan;
		list = new ArrayList<Board>();
	}
	public BoardManager(Scanner scan, int size) {
		this.scan = scan;
		list = new ArrayList<Board>(size);
	}
	
	private Board writingPost() {
		try {
			System.out.print("타입을 선택하세요 (예:공지 / 일반) : ");
			String type = scan.next();
			scan.nextLine();
			System.out.print("작성자 이름을 입력하세요 : ");
			String writer = scan.nextLine();
			System.out.print("제목을 입력하세요 : ");
			String title = scan.nextLine();
			System.out.println("내용을 입력하세요 : ");
			String content = scan.nextLine();
			return new Board(type, title, content, writer);
		} catch (Exception e) {
			System.out.println("잘못된 값을 입력했습니다.");
			scan.nextLine();
			return null;
		}
	}

	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("--------메뉴--------");
		System.out.println("1. 게시글 등록 (공지 / 일반)");
		System.out.println("2. 게시글 확인");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = scan.nextInt();
		System.out.println("-------------------");
		return menu;
	}

	@Override
	public void excute(int menu) {
		switch (menu) {
		case 1:
			Board brd = writingPost();
			postingBoard(brd);
			break;
		case 2:
			//전체 게시글 확인
			printPost();
			//게시글 선택
			
			
			
			Board board = new Board("타입", "제목", "내용", "작성자");
		//	System.out.println(board);
			//게시글 상세 확인
		//	board.detailPrint();
			break;
		case 3:
			//게시글 수정 기능
			//전체 게시글 확인
			printPost();
			//게시글 선택
			//게시글 제목, 내용 입력
			//게시글 수정
			modifyPost();
			
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴를 선택했습니다.");
		}
	}

	@Override
	public void run() {
		int menu;
		do {
			try {
				menu = selectMenu(scan);
				excute(menu);
			} catch (Exception e) {
				menu = 0;
				System.out.println("잘못된 형태의 메뉴를 입력했습니다.");
				scan.nextLine();
			}
		} while (menu != exitMenu);
	}
	private void printMessage(String message) {
		System.out.println("-------------------");
		System.out.println(message);
		System.out.println("-------------------");
	}
	
	private void postingBoard(Board brd) {
		if(brd == null) {
			return;
		}
		if(list.contains(brd)) {
			printMessage("중복된 게시글입니다. 게시글 수정 메뉴를 이용해주세요.");
			return;
		}
		list.add(brd);
	list.sort(new Comparator<Board>() {
			@Override
			public int compare (Board b1, Board b2) {
				if(b1.getType().compareTo(b2.getType()) != 0) {
					return b1.getType().compareTo(b2.getType());
				}
				return b1.getNum() - b2.getNum();
			}
		});
		printMessage("게시글이 등록되었습니다.");
	}	
	private void printPost() {
		if(list.size() == 0) {
			printMessage("등록된 게시글이 없습니다.");
			return;
		}
		System.out.println("-------------------");
		for(Board tmp : list) {
			System.out.println(tmp);
		}
		System.out.println("-------------------");
	}
	private Board inputSearchBoard() {
		try {
			System.out.println("검색할 글의 번호을 입력하세요 : ");
			int num = scan.nextInt();
			return new Board(null, null, null, null);
		}catch(Exception e) {
			printMessage("잘못된 값을 입력했습니다. 입력이 취소됩니다.");
			//입력을 잘못했을 때 입력 버퍼에 있는 내용들을 문자열로 가져옴(입력버퍼를 비우는 역할)
			scan.nextLine();
			return null;
		}
	}
	private void modifyPost() {
		try {
			System.out.print("수정할 글의 번호를 선택하세요 : ");
			int num = scan.nextInt();
			System.out.print("수정할 글의 제목을 입력하세요  : ");
			scan.nextLine();
			String title = scan.nextLine();
			System.out.println("수정할 글의 내용을 입력하세요 : ");
			String content = scan.nextLine();
			list.get(num-1).modify(title, content);
			System.out.println("게시글이 수정되었습니다.");
		}catch(Exception e) {
			System.out.println("잘못된 입력입니다.");
			scan.nextLine();
			return;
		}
	}
	/* private Board readPost() {
		try {
			System.out.println("-------------------");
			System.out.println("전체 게시글 중 확인할 게시글 번호를 선택하세요 : ");
			int num = scan.nextInt();
			return new Board(num, title, writer, Date, view);			
		}catch(Exception e) {
			System.out.println("잘못된 입력입니다.");
			scan.nextLine();
			return null;
		}
	} */
}