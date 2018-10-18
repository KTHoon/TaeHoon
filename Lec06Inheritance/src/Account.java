
public class Account
{
	//멤버필드(데이터,속성)
	String accountNo; //계좌번호
	String OwnerName; //예금주
	int balance;		 //잔액
	
	Account() {}
	//생성자 - 멤버필드의 초기화
	Account(String accountNO , String OwnerName , int balance){
		this.accountNo=accountNO;
		this.OwnerName =OwnerName;
		this.balance = balance;
	}
	
	//멤버 메서드.
	
	//입금하다.
	void deposit(int amount) {
		balance +=amount;
	}
	//출금하다.
	int withdraw(int amount){
		if(balance <amount){
			System.out.println("잔액이 부족합니다.");
			return 0;
		}
		balance -=amount;
		return amount;
	}
	public static void main(String[] args) 
	{
		
	}
}
