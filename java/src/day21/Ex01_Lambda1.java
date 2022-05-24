package day21;

import java.util.function.*;

public class Ex01_Lambda1 {

	public static void main(String[] args) {
		//람다식을 쓰지 않고 쓰레드 생성 후 테스트
		Thread th1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("안녕");
			}
		});
		th1.start();
		
		//람다식을 이용하여 쓰레드 생성 후 테스트
		Thread th2 = new Thread(() -> System.out.println("Hi"));
		th2.start();

		Thread th3 = new Thread(() -> {
			System.out.println("Hello");
		});
		th3.start();
	}

}
