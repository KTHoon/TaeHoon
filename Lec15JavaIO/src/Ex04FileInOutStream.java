import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//문자기반의 stream은 byte기반이어서 한글이 제대로 출력되지 않아 좋지 않음

public class Ex04FileInOutStream {
	public static void main(String[] args) {
		
		File source= new File("/home/pc15/io/gnome-tyr_02.png");
		File target =new File("/home/pc15/io/gnome-tyr_02_copy.png");
		
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream(source);
			fos=new FileOutputStream(target);
			while(true) {
				int x =fis.read();
				if(x==-1) {
					break;
				}
				fos.write(x);
			}
			System.out.println("파일 복사 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			}catch(IOException e) {}
		}
	}
}
