public class Ex02StaticInner {
	int outField1 = 10;
	int outField2 = 20;
	static int outField3=30;//Outer 클래스에 생성가능.
	
	//Inner 클래스(Nested class)
	static class Inner{
		int inField1=100;
		int inField2=200;
		static int inField3=300;//static 구성요소를 사용가능/클래스에 static 선언.
		
		public void print() {
			System.out.println("===== Inner.print()호출 =====");
			System.out.println("inField1=>"+inField1);
			System.out.println("inField2=>"+inField2);
			//System.out.println("outField1=>"+outField1);
			System.out.println("outField2=>"+outField3);
			
			//Outer클래스의 멤버접근 가능.
			//Outer 클래스의 static은 사용가능.
			//static 사용시 Outer클래스의 non-static 사용 불가능
		}
	}
	public static void main(String[] args) {
		//Outer객체 생성없이 클래스명으로 Inner클래스의 객체 생성.
		Ex02StaticInner.Inner inner= new Ex02StaticInner.Inner();
		inner.print();
	}
	
}
