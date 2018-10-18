
public class AppCDInfo extends CDInfo implements Lendable{
	
	String borrower; //대출인
	String date;//대출일
	int state;//대출상태(0:대출가능 , 1:대출불가(대출중))

	
	AppCDInfo(String registerNo,String title)
	{
		super(registerNo,title);
	}

	@Override
	public void checkOut(String borrower, String date) {
		if(this.state == STATE_NORMAL) {
		this.borrower = borrower;
		this.date =date;
		this.state =STATE_BORROWED;
		System.out.println("====== 부록CD 대출 ======");
		System.out.println("부록CD"+title+"이 대출되었습니다.\n"+"빌려간 사람:"+borrower);
		}else {
			System.out.println("부록CD"+title+"이 대출 불가합니다.");
		}
	}

	@Override
	public void checkIn() {	
		this.borrower = null;
		this.date=null;
		this.state=STATE_NORMAL;
	}
	
}
