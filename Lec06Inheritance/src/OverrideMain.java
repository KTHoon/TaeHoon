
public class OverrideMain {
	public static void main(String[] args) {
		CreditLineAccount minus = new CreditLineAccount("1234-5678-9874", "Tac", 100000, 5000000);
		
		//자식 클래스에서 재정의한 메서드가 호출. -> withdraw
		int money = minus.withdraw(500000);
		
		System.out.println("인출 금액 : " + money);
		System.out.println("잔액 : " + minus.balance);
		System.out.println();
		BonusPointAccount bonus = new BonusPointAccount("1234-456-789", "TaT", 200000, 1000);
		
		//자식 클래스에서 재정의한 메서드 호출  ->deposit
		bonus.deposit(2000000);
		System.out.println("잔  액:" + bonus.balance);
		System.out.println("포인트:" + bonus.bonusPoint);
	}
}
