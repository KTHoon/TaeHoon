class SampleThread extends Thread{
	@Override //로직 구현을 하는 메인 같은 부분.
	public void run() {
		System.out.println("스레드 명: "+Thread.currentThread().getName());
		for(int i=1; i<41; i++) {
			System.out.print(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Ex01MultiThread {
	public static void main(String[] args) {
		System.out.println("스레드 명: " + Thread.currentThread().getName()+"시작.");
		
		SampleThread thread = new SampleThread();
		thread.setDaemon(true);//데몬 스레드
		thread.start();//스레드 시작
		
		//System.out.println();
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.print(ch);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("스레드 명: " + Thread.currentThread().getName()+"종료.");
	}
}