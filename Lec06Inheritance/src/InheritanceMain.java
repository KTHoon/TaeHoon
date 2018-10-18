public class InheritanceMain {
	public static void main(String[] args) {		
		CheckingAccount check =
				new CheckingAccount("789-456-123", "설현", 1500000, "8556-9685-7845-9658");
		
		//부모 클래스로부터 상속 받은 메서드 호출
		int amount = check.withdraw(200000);
		
		System.out.println("인출한 금액 : " + amount);
		System.out.println("잔 액 : " + check.balance );

		//자신의 메서드 호출
		amount = check.pay(new String("8556-9685-7845-9658"), 150000);
		System.out.println("지불한 금액 : " + amount);
		System.out.println("잔 액 : " + check.balance );
	}
}

