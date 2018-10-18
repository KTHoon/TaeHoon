public class CheckingAccount extends Account
{
	//필드
	String cardNo; //카드번호
	CheckingAccount(String accountNo,String OwnerName, 
						int balance,String cardNo){
		
		//super();//상위 클래스의 생성자. 디폴트로 생성됨(상위 클래스에 디폴트 생성자가 있을 경우) 반드시 첫 줄.
		super(accountNo,OwnerName,balance); //부모 클래스의 명시적 선언 ,디폴트 super()생성자가 생김.
		/*super.accountNo = accountNo;
		super.OwnerName = OwnerName;
		super.balance = balance;*/
		//자신의 멤버필드만 초기화 상속필드는 SUPER
		this.cardNo = cardNo;
	}
		//메서드
		//직불카드 사용액 지불
		int pay(String cardNo,int amount) {
			
			//== ,!=(기본형 비교연산자)
			if(!this.cardNo.equals(cardNo) || balance<amount) {
				System.out.println("지불 불가합니다.");
				return 0;
			}
			balance -= amount;
			return amount;
	}
}