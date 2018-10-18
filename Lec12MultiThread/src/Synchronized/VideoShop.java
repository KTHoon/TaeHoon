package Synchronized;
import java.util.Vector;

public class VideoShop {
	Vector<String> videoList = new Vector<>();
	
	public VideoShop() {
		videoList.add("밴드 오브 브라더스 1-1");
		videoList.add("밴드 오브 브라더스 1-2");
		videoList.add("밴드 오브 브라더스 1-3");
		videoList.add("밴드 오브 브라더스 1-4");
	}
	//비디오 대여.
	public synchronized String lendVideo() {
		while(videoList.size()==0) {
		if(videoList.size()==0){
			//return null;
			try {
				System.out.println(Thread.currentThread().getName()+" 대기 중...");
				wait();//스레드 대기 상태.
			} catch (InterruptedException e) {
			}
		 }
		}
		String video = videoList.remove(videoList.size()-1);
		return video;
	}
	//비디오 반납
	public synchronized void returnVideo(String video) {
		videoList.add(video);
		//notify();//대기 상태의 스레드를 실행가능 상태로 만듬.
		notifyAll();//while문 없이 사용시 인덱스 오류 발생.
	}
}
