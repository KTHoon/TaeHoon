package Synchronized;

public class Husband extends Thread{
	public Husband(String name) {
		setName(name);//Thread 상속
	}
	@Override
	public void run() {
		Ex03SynchMain.bank.saveMoney(50000);
		
		System.out.println(Thread.currentThread().getName()
				            +"=> saveMoney(50000)"
				            +Ex03SynchMain.bank.getBalance());
	}
}
