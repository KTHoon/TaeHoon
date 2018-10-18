import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex06BufferedInOutStream {
	public static void main(String[] args) {
		
		//"일반 Stream" 과 "buffer Stream"의 속도 비교.
		
		File source = new File("/home/pc15/io/StayWithMeMV.m4v");
		File target1 = new File("/home/pc15/io/StayWithMeMV_copy1.m4v");
		File target2 = new File("/home/pc15/io/StayWithMeMV_copy2.m4v");
		
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		try {
			System.out.println("일반 스트림 수행시간 측정");
			fis= new FileInputStream(source);
			fos=new FileOutputStream(target1);
			
			long startTime=System.currentTimeMillis();
			while(true) {
				int x = fis.read();
				if(x==-1) break;
				fos.write(x);
			}
			long DurationTime=System.currentTimeMillis()-startTime;
			System.out.println("일반 Stream : " + DurationTime);
			
			System.out.println("=============================");
			
			System.out.println("Buffered Stream 수행시간 측정");
			
			bis= new BufferedInputStream(new FileInputStream(source));
			bos= new BufferedOutputStream(new FileOutputStream(target2));
			
			startTime=System.currentTimeMillis();
			while(true) {
				int x = bis.read();
				if(x==-1) break;
				bos.write(x);
			}
			//bos.flush();
			DurationTime=System.currentTimeMillis()-startTime;
			System.out.println("Buffered Stream : "+ DurationTime);
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//자원 해제
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
				if(bis!=null) bis.close();
				if(bos!=null) bos.close();
			}catch(IOException e) {}
		}
		
	}
}
