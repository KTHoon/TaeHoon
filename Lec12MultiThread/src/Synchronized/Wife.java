package Synchronized;

public class Wife extends Thread{
	public Wife(String name) {
		super(name);
	}
@Override
	public void run() {
		Ex03SynchMain.bank.minusMoney(30000);
		System.out.println(Thread.currentThread().getName()
				               +"=> minusMoney(30000)"+
				               Ex03SynchMain.bank.getBalance());
	}
}
