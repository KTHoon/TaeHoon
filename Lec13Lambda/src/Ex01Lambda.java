
public class Ex01Lambda {
	
	public static void main(String[] args) {
		//멀티 스레드 기존방식
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("기존 익명 중첩 클래스 방식.");
			}
		});
		t1.start();
	//람다식
		Thread t2 = new Thread(() ->System.out.println("람다식 방식."));
		t2.start();
	}
}
