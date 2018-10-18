
public class CreditLineAccount extends Account{
	int creditLine;
	
	CreditLineAccount(String accountNo,String ownerName,int balance,int creditLine){
		super(accountNo,ownerName,balance);
		//자신의 멤버필드만 초기화 상속필드는 SUPER
		this.creditLine = creditLine;
	}
	@Override
	//출금하다 -> 오버라이딩(재정의),메소드 명이 같아야함. @Override Annotation
	int withdraw(int amount) {
		if((creditLine + balance) <amount) {
			System.out.println("잔액이 부족합니다.");
			return 0;
		}
		balance -=amount;
		return amount;
	}
}
