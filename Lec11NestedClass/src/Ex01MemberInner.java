public class Ex01MemberInner {
	//필드 
	int outField1=10;
	int outField2=20;
	
	//멤버 이너 클래스
	class Inner{
		int inField1=100;
		int inField2=200;
		
		public void print() {
			System.out.println("inField1->"+inField1);
			System.out.println("inField2->"+inField2);
			System.out.println("outField1->"+outField1); 
			System.out.println("outField3->"+outField2);
			
			
		}
	}
	
	//메서드
	public void disp() {
		Inner in=new Inner();
		in.print();
	}
	public static void main(String[] args) {
		Ex01MemberInner outer = new Ex01MemberInner();
		
		//outer.disp();
		//외부에서 사용할 때,main()메서드에서 사용할 때
		Ex01MemberInner.Inner inner = outer.new Inner();
		inner.print();
	}
}
