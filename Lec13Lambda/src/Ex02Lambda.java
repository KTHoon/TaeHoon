
public class Ex02Lambda {
	public static void main(String[] args) {
		//기존 방식
		MyFunctionalInterface mfi = new MyFunctionalInterface(){	
			@Override
			public int method(int x, int y) {
				return x+y;
			}
		};
		System.out.println("기존 방식 : " +mfi.method(10, 20));
		
		//람다식
		mfi=(x,y) -> {return x-y;};
		System.out.println("람다식 #1: " + mfi.method(10, 20));
		
		mfi=(x,y) ->  x*y; //바로 return시
		System.out.println("람다식 #2: " + mfi.method(10, 20));
	}
}
