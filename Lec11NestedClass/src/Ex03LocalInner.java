public class Ex03LocalInner {
	int outField=10;
	
	
	public void disp(final String msg) {
		final int localVar = 2000;//지역 변수. 상수
		//Local Inner Class
		class Inner{
			int inField=100;
			
			public void print() {
				System.out.println("===== Inner.prit() =====");
				System.out.println("inField =>" + inField);
				System.out.println("outField =>" + outField);
				System.out.println("localVar =>" + localVar);//상수 지역변수만 사용 가능.
				System.out.println("Stringmsg =>" + msg);
			}
		}
		//객체 생성.
		Inner inner = new Inner();
		inner.print();
	}
	public static void main(String[] args) {
		Ex03LocalInner outer = new Ex03LocalInner();
		outer.disp("지역변수는 상수만 가능합니다.");
		
	}
}
