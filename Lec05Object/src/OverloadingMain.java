
class Calculator{
	public int plus(int a, int b) {
		return a+b;
	}
	static public float plus(float a, float b) {
		return a+b;                                    //오버로딩
	}
	public int minus(int a, int b) {
		return a-b;
	}
	public int multiple(int a, int b) {
		return a*b;
	}
	public int devide(int a, int b) {
		return a/b;
	}
}
public class OverloadingMain 
{
	public static void main(String[] args) 
	{
		Calculator cal = new Calculator();
		
		int x = 10;
		int y = 20;
		int z = cal.plus(x,y);
		System.out.println("z=" + z);
		
		float a =Calculator.plus(3.14f,2.14f);
		System.out.println("a="+a);
	}
}
