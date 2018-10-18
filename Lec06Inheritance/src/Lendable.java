
public interface Lendable {
	
	static final int STATE_NORMAL =0; //심볼릭 상수,숫자대신 문자를 넣어 가독성
	int STATE_BORROWED =1;//static final 자동 삽입
	
	//대출하다.
	//public abstract 인터페이스에선 자동으로 사용해줌
	public abstract void checkOut(String borrower,String date);
	
	//반납하다.
	void checkIn();
}
