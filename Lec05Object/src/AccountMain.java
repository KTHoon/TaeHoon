
public class AccountMain
{	
	public static void main(String[] args)
	{
		Account acc1 = new Account("123-12-4567","태훈",300000);
		Account acc2 = new Account("231-21-7654","훈김",150000);
		
		int amount=acc1.withdraw(70000); //출금,메서드 호출
		acc2.deposit(amount);//입금
		
		System.out.println("예금주 :" +acc1.OwnerName+"\t잔액 확인: " + acc1.balance);
		System.out.println("예금주 :" +acc2.OwnerName+"\t잔액 확인: " + acc2.balance);
	}
}
