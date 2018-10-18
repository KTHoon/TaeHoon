
public class Polymorphism  //업캐스팅.
{
	public static void main(String[] args) {
		Account acc= new Account("123-436-631","Woo",150000);
		//상위크래스 변수 =new 하위클래스(); ==>업캐스팅.
		Account check = new CheckingAccount("123-123456-789","Wow", 450000, "123-456-789");
		CreditLineAccount minus = new CreditLineAccount("123-456-789-987", "dodol", 200000, 5000000);
		BonusPointAccount bonus  = new BonusPointAccount("123-123-44576-7", "Got", 950000, 1200);
		
		display(acc);
		display(check);
		display(minus);
		display(bonus);

	}
	public static void display(Account acc) {
		System.out.println("=====계좌 정보=====");
		System.out.println("계좌번호 : " + acc.accountNo);
		System.out.println("예금주 : " + acc.OwnerName);
		System.out.println("잔액 : " + acc.balance);
		if(acc instanceof BonusPointAccount) {
		//다운 캐스팅,원래의 형으로 복귀.
		BonusPointAccount bonus = (BonusPointAccount)acc;
		System.out.println("포인트: "+bonus.bonusPoint);
		}
		System.out.println();
	}
	/*public static void display(CheckingAccount check) {
		System.out.println("=====계좌 정보=====");
		System.out.println("계좌번호 : " + check.accountNo);
		System.out.println("예금주 : " + check.OwnerName);
		System.out.println("잔액 : " + check.balance);
		//System.out.println("카드 번호 : " + check.cardNo);
		System.out.println();
	}
	public static void display(CreditLineAccount minus) {
		System.out.println("=====계좌 정보=====");
		System.out.println("계좌번호 : " + minus.accountNo);
		System.out.println("예금주 : " + minus.OwnerName);
		System.out.println("잔액 : " + minus.balance);
		//System.out.println("마이너스 통장 : " + minus.creditLine);
		System.out.println();
	}
	public static void display(BonusPointAccount bonus) {
		System.out.println("=====계좌 정보=====");
		System.out.println("계좌번호 : " + bonus.accountNo);
		System.out.println("예금주 : " + bonus.OwnerName);
		System.out.println("잔액 : " + bonus.balance);
		//System.out.println("보너스 포인트 : " + bonus.bonusPoint);
		System.out.println();
	}*/
}
