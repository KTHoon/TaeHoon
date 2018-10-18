
public class Accumulator 
{
	//멤버 필드
	int total;		//인스턴스 필드
	static int grandTotal;	//클래스 필드(정적 필드/static filed)
	
	//생성자
	Accumulator(){} //디폴트 생성자
	
	//멤버 메서드
	void accumlate(int amount)
	{
		total+=amount;
		grandTotal+=amount;
	}
	//클래스 메소드(정적메서드)
	static int getGrandTotal() { //인스턴스 메소드
		//total=120; //인스턴스 필드(인스턴스 메서드)는 사용 불가능.
		return grandTotal;
	}
}
