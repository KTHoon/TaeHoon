
public class InterfaceMain {
	public static void main(String[] args) {
		/*book1.checkOut("이산","2018/07/17");
		cd1.checkOut("이산","2018/07/17");
		book2.checkOut("이산","2018/07/17");
		cd2.checkOut("이산","2018/07/17");*/
		
		//업캐스팅. 데이터타입이 같아 배열 가능.
	 /*Lendable book1 = new SeparateVolume("가-4567","이것이 자바다","신용권");
		Lendable cd1 = new AppCDInfo("123-45-6789","리눅스 설치 부록CD");
		Lendable book2 = new SeparateVolume("나-1234","오라클SQL활용","나다");
		Lendable cd2 = new AppCDInfo("231-45-6789","Microsoft office2010 부록CD");
		*/
		Lendable[] lendList = {
				new SeparateVolume("가-4567","이것이 자바다","신용권"),
				new AppCDInfo("123-45-6789","리눅스 설치 부록CD"),
				new SeparateVolume("나-1234","오라클SQL활용","나다"),
				new AppCDInfo("231-45-6789","Microsoft office2010 부록CD")
		};
		checkOutAll(lendList,"설현","2018-07-17");	
	}
	public static void checkOutAll(Lendable[] lendList,String borrower,String date) {
		for(int i=0; i<lendList.length; i++){
			lendList[i].checkOut(borrower, date);
		}
	}
}
