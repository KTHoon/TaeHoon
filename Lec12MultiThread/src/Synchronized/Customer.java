package Synchronized;

public class Customer extends Thread {
	public Customer(String name) {
		this.setName(name);
	}
	@Override
	public void run() {
		
		//synchronized (VideoShopMain.videoShop) {
			String video = VideoShopMain.videoShop.lendVideo();
			
			/*if(video==null) {
				System.out.println(getName()+"대여 실패...OTL...");
				return;
			}*/
			System.out.println(getName()+" 가"+video+"대여.");
			System.out.println(getName()+" 가"+video+"시청 중.");
			try {
				int x=(int)(Math.random()*3)+1;
				Thread.sleep(1000*x);
			} catch (InterruptedException e) {
			}
			VideoShopMain.videoShop.returnVideo(video);
			System.out.println(getName()+" 가"+video+"반납.");
		//	}
		
	}
}
