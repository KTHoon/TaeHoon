package Synchronized;

public class VideoShopMain {
	
	//공유자원
	public static VideoShop videoShop = new VideoShop();
	
	public static void main(String[] args) {
		Customer c1 = new Customer("태식");
		Customer c2 = new Customer("재준");
		Customer c3 = new Customer("진병");
		Customer c4 = new Customer("충호");
		Customer c5 = new Customer("원미");
		Customer c6 = new Customer("한조");
		
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
	}
}
