package Synchronized;

public class Bank {
	int balance = 100000;
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	//동기화 메서드 (synchronized method) 전체
	public synchronized void saveMoney(int amount) {
		int money = getBalance();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		setBalance(money+amount);
	}
	//동기화 블럭(synchronized block) 일부
	public void minusMoney(int amount) {
		 synchronized(this){//(this)동기화 시킬 대상
			int money=getBalance();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			setBalance(money-amount);
		}
	}
}
