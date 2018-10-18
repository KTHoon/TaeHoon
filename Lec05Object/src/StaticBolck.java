
public class StaticBolck 
{
 	static int a = 10;
	static int b = 20;
	static int[] num = new int[100];
	
	//정적 초기화블럭.
	static {
		//로직수행
		for(int i=0; i<num.length; i++)
		{
			num[i]+=(i+1)*3;
			System.out.print(num[i]+", ");
		}
	}
	public static void main(String[] args) {
		
	}
}
