
public class SeparateVolume implements Lendable {

	String requestNo;
	String bookTitle;
	String writer;
	
	String borrower;
	String date;
	int state;

	SeparateVolume(String requestNo,String bookTitle,String writer){
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	@Override
	public void checkOut(String borrower, String date) {
		if(this.state == STATE_NORMAL) {
		this.borrower = borrower;
		this.date =date;
		this.state =STATE_BORROWED;
		System.out.println("====== 단행본CD 대출 ======");
		System.out.println("단행본"+bookTitle+"이 대출되었습니다.\n"+"빌려간 사람:"+borrower);
		}else {
			System.out.println("단행본"+bookTitle+"이 대출 불가합니다.");
		}
	}
	@Override
	public void checkIn() {	
		this.borrower = null;
		this.date=null;
		this.state=STATE_NORMAL;
	}
	
}
