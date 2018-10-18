package Synchronized;

public class Ex03SynchMain {
	
	//공유자원
	public static Bank bank =new Bank();
	
	public static void main(String[] args) {
		System.out.println("Main Thread 시작");
		
		System.out.println("현재 잔액: " + bank.getBalance());
		
		Husband h = new Husband("이산");
		Wife w = new Wife("설현");
		
		h.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
		w.start();
		
		System.out.println("Main Thread 종료");
	}
}
