
public class AccumulatorMain 
{
	public static void main(String[] args) {
        //static을 사용한 클래스필드(정적필드)는 객체생성x
         //멤버변수를 static안에 넣어 사용하면 오류
		
		//정적 메소드이기에 클래스명으로 접근.
		Accumulator.grandTotal=10;
		Accumulator.grandTotal=20;
		Accumulator.grandTotal=30;
		System.out.println("Acumulator.getGreandTotal()="+Accumulator.getGrandTotal());
		//객체 생성(인스턴스 생성)
		Accumulator acc1 = new Accumulator();
		Accumulator acc2 = new Accumulator();
		
		acc1.accumlate(100);
		acc2.accumlate(150);
		
		System.out.println("acc1.total=" + acc1.total);
		System.out.println("acc1.grandTotal=" + Accumulator.grandTotal);
        //객체에 소속되어 있지 않기에 클래스로 접근가능,객체생성이 필요없음
		System.out.println("acc2.total=" + acc2.total);
		System.out.println("acc2.grandTotal=" + Accumulator.grandTotal);
	}
}
