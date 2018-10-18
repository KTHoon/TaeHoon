interface ISample{
	public void methodC();
}
class Sample{
	public void methodA() {
		System.out.println("===== methodA() 실행 =====");
	}
	public void methodB() {
		System.out.println("===== methodB() 실행 =====");
	}
}
public class Ex04AnonymousInner {
	
	public void handle(ISample s) {
		System.out.println("===> handle메서드 실행");
		s.methodC();
	}
	
	public void disp() {
		System.out.println("==== 기존 객체 사용 방법 ====");
		Sample sample = new Sample();
		sample.methodA();
		sample.methodB();
		
		System.out.println("\n==== 익명 중첩 클래스 #1(객체 생성O) ====");
		Sample s2 = new Sample() {
			@Override
			public void methodA() {
				System.out.println("===> 새로운 methodA() 입니다.");
				//super.methodA();
			}
		};
		s2.methodA();
		s2.methodB();
		
		System.out.println("\n==== 익명 중첩 클래스 #2(객체 생성X) ====");
		new Sample() {
			@Override
			public void methodB() {
				System.out.println("===> 재정의된 methodB() 호출");
				//super.methodB();
			}
		}.methodB();
		
		System.out.println("\n==== 익명 중첩 클래스 #3(인터페이스) ====");
		ISample s3 = new ISample() {//new ISample() 
			@Override
			public void methodC() {
				System.out.println("===> Interface methodc() 호출");
			}
		};
		s3.methodC();
		//.methodC();
		
		System.out.println("\n==== 익명 중첩 클래스 #4(다른 메소드의 지역변수로 사용) ====");			
		handle(s3);
		handle(new ISample() {
			@Override
			public void methodC() {
				System.out.println("==> 재정의된 method() 호출");
			}
		});
	}
	public static void main(String[] args) {
		Ex04AnonymousInner outer = new Ex04AnonymousInner();
		outer.disp();
	}
}
