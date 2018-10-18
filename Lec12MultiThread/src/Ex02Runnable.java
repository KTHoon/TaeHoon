class RunnableThread implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName()+" 스레드 실행."+i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Ex02Runnable {
	public static void main(String[] args) {
		System.out.println("==>메인 스레드 시작");
		RunnableThread target = new RunnableThread();
		
		Thread  thread1 = new Thread(target);
		thread1.setName("이산");
		thread1.start();
		
		Thread thread2 = new Thread(target,"설현");
		thread2.start();
		
		//익명 중첩 클래스 방식
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
			for(int i=0; i<5; i++) {
				System.out.println(">>>"+Thread.currentThread().getName());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		});
		thread3.setName("현빈");
		thread3.start();
		System.out.println("==>메인 스레드 종료");
	}
}
